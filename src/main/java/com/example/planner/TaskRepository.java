package com.example.planner;

import com.example.planner.main.Category;
import com.example.planner.main.Priority;
import com.example.planner.main.Task;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class TaskRepository {

    private Task task;

    public void createTask(String title,
                           LocalDate taskDate,
                           Priority priority,
                           Category category,
                           String description){
        Task task = new Task(title, taskDate, priority, category, description);
        System.out.println("Task created: " + task.getTaskTitle());
    }
}
