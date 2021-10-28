package com.example.planner.controller;

import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import com.example.planner.service.TaskService;
import com.example.planner.service.dto.TaskView;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
//@RequestMapping("/api/planner")
public class ReadPlannerController {

    @NonNull
    private final TaskService taskService;

//    @GetMapping("/tasks")
//    public String getAll(Model model) {
//        Task task1 = taskService.createTask("Wysłać email",
//                LocalDate.of(2021,11,14),
//                Priority.MEDIUM,
//                Category.OTHER,
//                "do: janN33@gmail.com");
//
//        Task task2 = taskService.createTask("Odebrać paczke",
//                LocalDate.of(2021,11,01),
//                Priority.LOW,
//                Category.WORK,
//                "adres...");
//
//        Task task3 = taskService.createTask("Spotkanie z Martą",
//                LocalDate.of(2021,11,22),
//                Priority.HIGH,
//                Category.SOCIAL_LIFE,
//                "Zabrać prezent!");
//
//        List<TaskView> tasks = taskService.getAllTasks();

//        model.addAttribute("tasks",tasks);
//        return "main";
//    }

    @GetMapping("/tasks")
    public String getAll(Model model) {
        Task task1 = new Task("Wysłać email",
                LocalDate.of(2021,11,14),
                Priority.MEDIUM,
                Category.OTHER,
                "do: janN33@gmail.com");

        Task task2 = new Task("Odebrać paczke",
                LocalDate.of(2021,11,01),
                Priority.LOW,
                Category.WORK,
                "adres...");


        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        model.addAttribute("tasks",tasks);
        return "main";
    }


}
