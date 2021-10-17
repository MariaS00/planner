package com.example.planner.forms;

import com.example.planner.main.Task;
import com.example.planner.main.ToDoList;
import com.example.planner.main.User;

import java.util.Map;

public class AllForms {

    private Map<User, Task> temporaryList;
    private User user;

    // sprawdzenie wolnego czasu

    public Task saveToList(Task task){
        // task repo create

        System.out.println("Added to list!");
        return temporaryList.put(user,task);
    }

    public Task removeFromList(){

        return null;
    }

    public Task editTask(){

        return null;
    }
}
