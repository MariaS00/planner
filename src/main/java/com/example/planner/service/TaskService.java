package com.example.planner.service;

import com.example.planner.repository.TaskRepository;
import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(String title,
                           LocalDate taskDate,
                           Priority priority,
                           Category category,
                           String description){
        Task task = new Task(title, taskDate, priority, category, description);
        System.out.println("Task created: " + task.getTaskTitle());
        //taskRepository.existsAllBy(task);
        taskRepository.save(task);
    }

//    public Task saveToList(User user, Task task){
//        System.out.println("Added to list!");
//        return taskMap.put(user,task);
//    }

    public void removeFromList(String title) {
        Task task = taskRepository.findByTaskTitle(title);
        taskRepository.delete(task);
    }

//    public List<Task> getTasksByCategoryOrderByDate(Category category, LocalDate date){
//        return taskRepository.findAllByTaskCategoryOrderByTaskDate(category,date);
//    }

    public List<Task> getAllTasks(){
        return new ArrayList<>(taskRepository.findAll());
    }


    public Task editTask(){
    // data, priority
        return null;
    }
}
