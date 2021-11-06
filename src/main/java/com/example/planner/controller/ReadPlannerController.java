package com.example.planner.controller;

import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import com.example.planner.service.TaskService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/api/planner")
public class ReadPlannerController {

    @NonNull
    private final TaskService taskService;

    private List<Task> tasks;

//    public ReadPlannerController() {
//        Task task1 = new Task("Wysłać email",
//                LocalDate.of(2021,11,14),
//                Priority.MEDIUM,
//                Category.OTHER,
//                "do: janN33@gmail.com");
//
//        Task task2 = new Task("Odebrać paczke",
//                LocalDate.of(2021,11,01),
//                Priority.LOW,
//                Category.WORK,
//                "adres...");
//
//        tasks = new ArrayList<>();
//        tasks.add(task1);
//        tasks.add(task2);
//    }

    @GetMapping("/tasks")
    public String getAll(Model model) {
        model.addAttribute("tasks",tasks);
        model.addAttribute("newTask",new Task());
        return "task";
    }

    @PostMapping("/add-task")
    public String addTask(@ModelAttribute Task task){
        tasks.add(task);
        return "redirect:/tasks";
    }


}
