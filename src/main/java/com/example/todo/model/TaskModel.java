package com.example.todo.model;

import com.example.todo.util.TaskPrio;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "task")

public class TaskModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "creating_date")
    private LocalDateTime creatingDate;
    @Column(name = "deadline")
    private String deadline;
    @Column(name = "is_complete")
    private boolean isComplete = false;
    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private TaskPrio priority;

    public TaskModel(String name, String description,
                     String deadline, TaskPrio priority) {
        this.name = name;
        this.description = description;
        this.creatingDate = LocalDateTime.now();
        this.deadline = deadline;
        this.priority = priority;
    }

    public TaskModel() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(LocalDateTime creatingDate) {
        this.creatingDate = creatingDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public TaskPrio getPriority() {
        return priority;
    }

    public void setPriority(TaskPrio priority) {
        this.priority = priority;
    }
}
