package com.example.todo.controller;

import com.example.todo.model.TaskModel;
import com.example.todo.repo.TaskRepo;
import com.example.todo.util.TaskPrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskWebController {
    @Autowired
    private TaskRepo taskRepo;

    @PostMapping("/addTask")
    public String addTask(@RequestParam String name, @RequestParam String description,
                          @RequestParam String deadline, @RequestParam TaskPrio priority, Model model){
        TaskModel task = new TaskModel(name, description, deadline, priority);
        taskRepo.save(task);
        return "redirect:/alltasks";
    }

    @GetMapping("/tasks")
    public String viewTasks(Model model) {
        List<TaskModel> tasks = taskRepo.findAll();
        model.addAttribute("tasks", tasks);
        return "allTasks";
    }

    @DeleteMapping("/deleteTask")
    public List<TaskWebController> deleteTask(){
        return null;
    }

    @GetMapping("/viewTask")
    public List<TaskWebController> viewTask(){
        return null;
    }

    //TODO add an edit task.

}
