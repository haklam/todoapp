import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Task } from './task';
import { TaskService } from './task.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  public task: Task[];
  public editTask: Task;

  constructor(private taskService: TaskService) { }

  ngOnInit(){
      this.getTask();
  }

  public getTask(): void{
    this.taskService.getTasks().subscribe(
      (response: Task[]) => {
        this.task = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddTask(addForm: NgForm): void{
    this.taskService.addTask(addForm.value).subscribe(
      (response: Task) => {
        console.log(response);
        this.getTask();
      },
      (error: HttpErrorResponse) => {
        alert(error.statusText);
      }
    );
    addForm.resetForm();
  }

  public onUpdateTask(task: Task): void {
    this.taskService.updateTask(task).subscribe(
      (response: Task) => {
        console.log(response);
        this.getTask();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteTask(taskId: number): void {
    this.taskService.deleteTask(taskId).subscribe(
      (response: void) => {
        console.log(response);
        this.getTask();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
  
    public onOpenModal(task: Task, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal')
    if (mode === 'edit') {
      this.editTask = task;
      button.setAttribute('data-target', '#updateEmployeeModal');
    }
    container.appendChild(button);
    button.click();
  }
}
