package com.example.planner.repository;

import com.example.planner.model.Category;
import com.example.planner.model.Priority;
import com.example.planner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    void delete(Task task);

    List<Task> findByTaskTitle(String title);

    List<Task> findAllByTaskCategory(Category category);

    List<Task> findAllByTaskDate(Date date);

    List<Task> findAllByTaskPriority(Priority priority);

    List<Task> findAllByTaskPriorityAndTaskDate(Priority priority, Date localDate);

    List<Task> findAllByDescriptionStartingWithIgnoreCase(String description);

    Long countAllByTaskDate(Date date);

    @Query("select (count(t) > 0) from Task t where t.taskId = ?1")
    boolean taskExists(UUID taskId);

    @Modifying
    @Query("update Task set taskPriority = :newPriority where taskId = :taskId")
    int updatePriority(@Param("newPriority") Priority newPriority, @Param("taskId") UUID taskId);

    @Modifying
    @Query("update Task set taskDate = :newDate where taskId = :taskId")
    int updateTaskDate(@Param("newDate") Date newDate,@Param("taskId") UUID taskId);

    @Modifying
    @Query("update Task set taskTitle = :newTitle where taskId = :taskId")
    int updateTaskTitle(@Param("newTitle") String newTitle,@Param("taskId") UUID taskId);

    @Modifying
    @Query("update Task set description = :newDescription where taskId = :taskId")
    int updateTaskDescription(@Param("newDescription") String newDescription,@Param("taskId") UUID taskId);

    @Modifying
    @Query("update Task set taskCategory = :newTaskCategory where taskId = :taskId")
    int updateTaskCategory(@Param("newTaskCategory") Category newTaskCategory,@Param("taskId") UUID taskId);




}
