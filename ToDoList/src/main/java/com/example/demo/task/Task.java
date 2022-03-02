package com.example.demo.task;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long id;
    private String content;
    private String title;
    private LocalDate created;

    public Task() {
    }

    public Task(Long id,
                String content,
                String title,
                LocalDate created) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.created = created;
    }

    public Task(String content,
                String title) {
        this.content = content;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String name) {
        this.content = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String email) {
        this.title = email;
    }

    public LocalDate getCreated() {
        return LocalDate.now();
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                ", created=" + created +
                '}';
    }
}
