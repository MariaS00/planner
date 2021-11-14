package com.example.planner.controller;

import com.example.planner.model.Task;
import com.example.planner.repository.TaskRepository;
import com.example.planner.service.TaskService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;


@Controller
@RequiredArgsConstructor
public class TaskController {

    @NonNull
    private final TaskService taskService;

    @NonNull
    private final TaskRepository taskRepository;


    @GetMapping("/tasks")
    public String createTask(Model model) {
        model.addAttribute("tasks",taskService.getAllTasks());
        model.addAttribute("newTask",new Task());
        return "task";
    }

    @PostMapping("/add-task")
    public String addTask(@ModelAttribute Task task){
        taskService.createTask(task.getTaskTitle(),
                task.getTaskDate(),
                task.getTaskPriority(),
                task.getTaskCategory(),
                task.getDescription());
        return "redirect:/displayAll";
    }

    @GetMapping("/displayAll")
    public String getAll(Model model) {
        model.addAttribute("tasks",taskService.getAllTasks());
        return "showAllTasks";
    }

    @GetMapping("/remove")
    public String removeTask(Model model){
        model.addAttribute("tasks",taskService.getAllTasks());
        return "removeTask";
    }

    @PostMapping("/remove/{taskId}")
    public String removeTask(@PathVariable UUID taskId) {
        Optional<Task> task1 = taskRepository.findById(taskId);
        if (task1.isPresent()){
            taskService.removeFromList(task1.get());
        }
        return "redirect:/displayAll";
    }

    @GetMapping("/edit/{taskId}")
    public String editTask(@PathVariable UUID taskId, Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        Optional<Task> task1 = taskRepository.findById(taskId);
        if (task1.isPresent()){
            model.addAttribute("editTask",task1.get());
        }
        return "editTask";
    }

    @PostMapping("/edit/{taskId}")
    public String editTask(@PathVariable UUID taskId,
                            @ModelAttribute Task newTask) {
        taskService.editTask(newTask);
        return "redirect:/displayAll";
    }

}
