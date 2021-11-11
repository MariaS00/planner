package com.example.planner.controller;

import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import com.example.planner.repository.TaskRepository;
import com.example.planner.service.TaskService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/api/planner")
public class TaskController {

    @NonNull
    private final TaskService taskService;

    @NonNull
    private final TaskRepository taskRepository;

//    private List<Task> tasks = new ArrayList<>();

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
//        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/displayAll")
    public String getAll(Model model) {
        model.addAttribute("tasks",taskService.getAllTasks());
        return "showAllTasks";
    }

    @PostMapping("/remove")
    public String removeTask(@ModelAttribute Task task){
        taskService.getAllTasks();
        taskService.removeFromList(task);
        return "removeTask";
    }


}
