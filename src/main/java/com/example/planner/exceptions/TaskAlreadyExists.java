package com.example.planner.exceptions;

public class TaskAlreadyExists extends RuntimeException {

    public TaskAlreadyExists(String message) {
        super(message);
    }

}
