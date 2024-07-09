package com.example.todo.controller;

import com.example.todo.model.TaskModel;
import com.example.todo.repo.TaskRepo;
import com.example.todo.util.TaskPrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/")
public class TaskController {
    @Autowired
    private TaskRepo taskRepo;

    @PostMapping("/addTask{name}{description}{creatingDate}{deadline}{isComplete}{priority}")
    public String addTask(@RequestParam String name,@RequestParam String description,
                          @RequestParam double deadline,@RequestParam boolean isComplete,@RequestParam TaskPrio priority){
        TaskModel task = new TaskModel(name, description, deadline, isComplete, priority);
        taskRepo.save(task);

        return "task added";
    }

    @DeleteMapping("/deleteTask")
    public List<TaskController> deleteTask(){
        return null;
    }

    @GetMapping("/viewTask")
    public List<TaskController> viewTask(){
        return null;
    }

    //TODO add an edit task.

}
