package com.example.planner.repository;

import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    void delete(Task task);

    Task findByTaskTitle(String title);

    List<Task> findAllByTaskCategory(Category category);

    List<Task> findAllByTaskDate(LocalDate date);

    List<Task> findAllByTaskPriority(Priority priority);

    List<Task> findAllByTaskPriorityAndTaskDate(Priority priority, LocalDate localDate);

    List<Task> findAllByDescriptionStartingWithIgnoreCase(String description);

    List<Task> countAllByTaskDate(LocalDate date);

    @Query("select (count(t) > 0) from Task t where t.taskId = ?1")
    boolean taskExists(UUID taskId);

    @Modifying
    @Query("update Task set taskPriority = : newPriority where taskId = : taskId")
    int updatePriority(Priority newPriority, UUID taskId);

    @Modifying
    @Query("update Task set taskDate = : newDate where taskId = : taskId")
    int updateTaskDate(LocalDate newDate, UUID taskId);

}
