package com.example.planner.service.dto;

import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import lombok.Value;

import java.time.LocalDate;
import java.util.UUID;

@Value
public class CreatedTask {

    UUID userId;
    UUID taskId;
    String taskTitle;
    LocalDate taskDate;
    Priority taskPriority;
    Category taskCategory;
    String description;
}
