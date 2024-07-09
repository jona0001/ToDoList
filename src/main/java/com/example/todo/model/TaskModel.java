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
    @Column(name = "creatingDate")
    private LocalDateTime creatingDate;
    @Column(name = "deadline")
    private double deadline;
    @Column(name = "isComplete")
    private boolean isComplete;
    @Column(name = "priority")
    private TaskPrio priority;

    public TaskModel(String name, String description,
                     double deadline, boolean isComplete, TaskPrio priority) {
        this.name = name;
        this.description = description;
        this.creatingDate = LocalDateTime.now();
        this.deadline = deadline;
        this.isComplete = isComplete;
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

    public double getDeadline() {
        return deadline;
    }

    public void setDeadline(double deadline) {
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
