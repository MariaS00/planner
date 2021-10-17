package com.example.planner.main;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Task {
    // TO DO
    //one to many - join !!!!!!!!!!!!!!!!

    @Id
    private UUID taskId;
    private String taskTitle;
    private LocalDate taskDate;
    private Priority taskPriority;
    private Category taskCategory;
    private String description;

    public Task(@NonNull String taskTitle,
                @NonNull LocalDate taskDate,
                @NonNull Priority taskPriority,
                @NonNull Category taskCategory,
                @NonNull String description) {
        this.taskId = UUID.randomUUID();
        this.taskTitle = taskTitle;
        this.taskDate = taskDate;
        this.taskPriority = taskPriority;
        this.taskCategory = taskCategory;
        this.description = description;
    }

    public Task(@NonNull String taskTitle,
                @NonNull LocalDate taskDate,
                @NonNull Priority taskPriority,
                @NonNull Category taskCategory) {
        this.taskId = UUID.randomUUID();
        this.taskTitle = taskTitle;
        this.taskDate = taskDate;
        this.taskPriority = taskPriority;
        this.taskCategory = taskCategory;
    }

    public Task() {
    }
}
