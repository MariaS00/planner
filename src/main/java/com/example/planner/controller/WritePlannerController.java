package com.example.planner.controller;

import com.example.planner.service.TaskService;
import com.example.planner.service.dto.CreatedTask;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class WritePlannerController {

    @NonNull
    private final TaskService taskService;

//    @GetMapping("/task")
//    ResponseEntity<CreatedTask> createdTaskResponseEntity(TaskView task){
//        return plannerService.createTask();
//    }


}
