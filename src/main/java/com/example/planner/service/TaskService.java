package com.example.planner.service;

import com.example.planner.model.User;
import com.example.planner.repository.TaskRepository;
import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import com.example.planner.service.dto.TaskView;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
//@RequiredArgsConstructor
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(String title,
                           LocalDateTime taskDate,
                           Priority priority,
                           Category category,
                           String description) {
        Task task = new Task(title, taskDate, priority, category, description);
        taskRepository.save(task);
        System.out.println("Task created: " + task.getTaskTitle());
    }

    public void removeFromList(Task task) {
            taskRepository.delete(task);
    }

    public List<TaskView> getAllTasks() {
        return taskRepository.findAll().stream().map(Task::toView).collect(Collectors.toList());
    }

    public void editTask(Task task) {
        taskRepository.updateTaskTitle(task.getTaskTitle(),task.getTaskId());
        taskRepository.updateTaskDate(task.getTaskDate(),task.getTaskId());
        taskRepository.updatePriority(task.getTaskPriority(),task.getTaskId());
        taskRepository.updateTaskCategory(task.getTaskCategory(),task.getTaskId());
        taskRepository.updateTaskDescription(task.getDescription(),task.getTaskId());
        taskRepository.save(task);
    }
}
