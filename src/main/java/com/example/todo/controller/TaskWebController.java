package com.example.todo.controller;

import com.example.todo.model.TaskModel;
import com.example.todo.repo.TaskRepo;
import com.example.todo.util.TaskPrio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
        return "redirect:/tasks";
    }
    @GetMapping("/tasks")
    public String viewTasks(Model model) {
        List<TaskModel> tasks = taskRepo.findAll();
        model.addAttribute("tasks", tasks);

        return "allTasks";
    }
    @DeleteMapping("/deleteTask")
    public String deleteTask(@RequestParam long id) {
        if (taskRepo.existsById(id)) {
            taskRepo.deleteById(id);
        }
        return "redirect:/tasks";
    }

    @GetMapping("/viewTask")
    public List<TaskWebController> viewTask(){
        return null;
    }

    @PostMapping("/taskCompleted")
    public String taskCompleted (@RequestParam long id){
        TaskModel taskmodel;
        taskmodel = taskRepo.getReferenceById(id);
        if (taskmodel.isComplete()) {
            taskmodel.setComplete(false);
            taskRepo.save(taskmodel);
        } else if (!taskmodel.isComplete()) {
            taskmodel.setComplete(true);
            taskRepo.save(taskmodel);{
            }
        }
        return "redirect:/tasks";
    }


    //TODO add an edit task.

}
