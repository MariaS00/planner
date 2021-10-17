package com.example.planner.forms;

import com.example.planner.TaskRepository;
import com.example.planner.main.Task;
import com.example.planner.main.User;

import java.util.List;
import java.util.Map;

public class AllForms {

    private Map<User, Task> taskMap;
    private User user;
    private TaskRepository repository;
    private List<Task> taskList;

    // sprawdzenie wolnego czasu
    // metoda show

    public Task saveToList(User user, Task task){
        System.out.println("Added to list!");
        return taskMap.put(user,task);
    }

    public void removeFromList(String title) {
        for (Task task : taskList) {
            if (task.getTaskTitle().contains(title)) {
                taskList.remove(task);
                System.out.println("Task removed.");
            }
        }
    }


    public Task editTask(){

        return null;
    }
}
