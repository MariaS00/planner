package com.example.planner.service.dto;

import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Value
public class TaskView {

    UUID taskId;
    String taskTitle;
    LocalDateTime taskDate;
    Priority taskPriority;
    Category taskCategory;
    String description;
}
