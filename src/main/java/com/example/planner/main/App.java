package com.example.planner.main;

import com.example.planner.TaskRepository;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {

        TaskRepository task = new TaskRepository();
        task.createTask("Prezenty",
                LocalDate.of(2021,12,6),
                Priority.HIGH,
                Category.SOCIAL_LIFE,
                "Dla mamy" );
    }
}
