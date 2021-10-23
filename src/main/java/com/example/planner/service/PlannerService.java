package com.example.planner.service;

import com.example.planner.TaskRepository;
import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import com.example.planner.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class PlannerService {

    private Map<User, Task> taskMap;
    private User user;
    private TaskRepository repository;
    private List<Task> taskList;

    // sprawdzenie wolnego czasu
    // metoda show/ getAll
    // ? list a repo a mapa = REPO

    public void createTask(String title,
                           LocalDate taskDate,
                           Priority priority,
                           Category category,
                           String description){
        Task task = new Task(title, taskDate, priority, category, description);
        System.out.println("Task created: " + task.getTaskTitle());
    }

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
    // data, priority
        return null;
    }
}
