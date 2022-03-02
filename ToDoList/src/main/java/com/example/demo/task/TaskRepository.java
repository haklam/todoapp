package com.example.demo.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository
        extends JpaRepository<Task, Long> {

    //  SELECT * FROM task WHERE email = ?
    Optional<Task> findTaskByTitle(String title);
}
