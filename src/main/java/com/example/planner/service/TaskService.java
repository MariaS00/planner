package com.example.planner.service;

import com.example.planner.repository.TaskRepository;
import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import com.example.planner.service.dto.TaskView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@Transactional
//@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(String title,
                           LocalDate taskDate,
                           Priority priority,
                           Category category,
                           String description) {
        Task task = new Task(title, taskDate, priority, category, description);
        System.out.println("Task created: " + task.getTaskTitle());
        //taskRepository.existsAllBy(task);
        taskRepository.save(task);
    }

    public void removeFromList(String title) {
        Task task = taskRepository.findByTaskTitle(title);
        taskRepository.delete(task);
    }

    public List<TaskView> getAllTasks() {
        return taskRepository.findAll().stream().map(Task::toView).collect(Collectors.toList());
    }

}
