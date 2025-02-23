package com.taskmanagement.demo.presentation;

import com.taskmanagement.demo.application.TaskService;
import com.taskmanagement.demo.application.TaskServiceImpl;
import com.taskmanagement.demo.domain.Priority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

    @Autowired
    private TaskService taskService;

    @GetMapping
    public String getAllTasks(Model model) {
        try {
            model.addAttribute("tasks", taskService.getAllTasks());
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error loading tasks: " + e.getMessage());
        }
        return "tasks";
    }

    @PostMapping
    public String createTask(@RequestParam String name, @RequestParam String priority, Model model) {
        try {
            taskService.createTask(name, Priority.valueOf(priority));
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error creating task: " + e.getMessage());
        }
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/update")
    public String updateTask(@PathVariable Long id, @RequestParam String name, @RequestParam boolean done, Model model) {
        try {
            logger.info("Updating task with id: {}", id);
            taskService.updateTask(id, name, done);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error updating task: " + e.getMessage());
        }
        return "redirect:/tasks";
    }

    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id, Model model) {
        try {
            taskService.deleteTask(id);
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Error deleting task: " + e.getMessage());
        }
        return "redirect:/tasks";
    }
}
