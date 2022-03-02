package com.example.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public void addNewTask(Task task) {
        Optional<Task> taskOptional = taskRepository
                .findTaskByTitle(task.getTitle());
        if (taskOptional.isPresent()){
            throw new IllegalStateException("Task already exists");
        }
        taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        boolean exists = taskRepository.existsById(taskId);
        if (!exists){
            throw new IllegalStateException("" +
                    "Task with id " + taskId + " does not exist");
        }
        taskRepository.deleteById(taskId);

    }

    @Transactional
    public void updateTask(Long taskId, String content, String title) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalStateException("Task with id " + taskId + " does not exist"));

        if(content != null && content.length() > 0 && !Objects.equals(task.getContent(), content)) {
            task.setContent(content);
        }
        if(title != null && title.length() > 0 && !Objects.equals(task.getTitle(), title)) {
            Optional<Task> taskOptional = taskRepository.findTaskByTitle(title);
            if (taskOptional.isPresent()) {
                throw new IllegalStateException("Task already exists");
            }
            task.setTitle(title);
        }
    }
}
