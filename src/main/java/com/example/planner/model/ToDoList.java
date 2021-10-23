package com.example.planner.model;

import com.example.planner.model.Task;
import com.example.planner.model.User;

import javax.persistence.Entity;
import java.util.HashMap;
import java.util.Map;

//@Entity
//kolejne repo
public class ToDoList {

    private final Map<User, Task> toDoList = new HashMap<>();
}
