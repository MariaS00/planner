package com.example.planner.db;

import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import com.example.planner.model.User;
import com.example.planner.repository.TaskRepository;
import com.example.planner.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class DbInitializer implements CommandLineRunner {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public DbInitializer(final TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        User user = userRepository.save(new User("Maria"));
//        Task meeting = taskRepository.save(new Task("Spotkanie",
//                Date.valueOf("2021-11-13"),
//                Priority.MEDIUM,
//                Category.WORK,
//                "O 12:00"));
//
//        taskRepository.findAll().forEach(System.out::println);
//        System.out.println(taskRepository.count());
    }
}
