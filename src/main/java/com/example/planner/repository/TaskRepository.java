package com.example.planner.repository;

import com.example.planner.model.Category;
import com.example.planner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    void delete(Task task);

//    Task existsAllBy(Task task);

    Task findByTaskTitle(String title);

  //  List<Task> findAllByTaskCategoryOrderByTaskDate(Category category, LocalDate date);

//    List<Task> countAllByTaskDate();


}
