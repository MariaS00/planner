package com.example.planner.controller;

import com.example.planner.service.PlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlannerController {

    private final PlannerService plannerService;

    // tutaj getMappingi

}
