package com.example.planner.service;

import com.example.planner.exceptions.TaskAlreadyExistsException;
import com.example.planner.exceptions.TaskNotExistsException;
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
        if (taskRepository.taskExists(task.getTaskId())){
            throw new TaskAlreadyExistsException("Task already exists: " + task.getTaskId());
        }else {
            System.out.println("Task created: " + task.getTaskTitle());
            taskRepository.save(task);
        }
    }

    public void removeFromList(String title) {
        try {
        Task task = taskRepository.findByTaskTitle(title);
        taskRepository.delete(task);
        }catch (TaskNotExistsException exception){
            System.out.println("Task does not exists.");
        }
    }

    public List<TaskView> getAllTasks() {
        return taskRepository.findAll().stream().map(Task::toView).collect(Collectors.toList());
    }

}
