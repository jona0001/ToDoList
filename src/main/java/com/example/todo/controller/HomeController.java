package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class HomeController {
@GetMapping("/")
    public String home(){
    return "home";
}

@GetMapping("/addTask")
    public String addTask(){
    return "addTask";
    }

@GetMapping("/allTasks")
    public String allTasks(){
    return "redirect:/allTasks";
    }
}
