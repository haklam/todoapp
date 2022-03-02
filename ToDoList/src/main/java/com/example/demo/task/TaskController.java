package com.example.demo.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public void registerNewTask(@RequestBody Task task){
        taskService.addNewTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void deleteStudent(
            @PathVariable("taskId") Long studentId){
        taskService.deleteTask(studentId);
    }

    @PutMapping(path = "{taskId}")
    public void updateStudent(
            @PathVariable("taskId") Long taskId,
            @RequestParam(required = false) String content,
            @RequestParam(required = false) String title) {
        taskService.updateTask(taskId, content, title);
    }
}

