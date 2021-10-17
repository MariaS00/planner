package com.example.planner.main;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Value;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
@Value
@AllArgsConstructor
public class Task {

    @Id
    private UUID taskId;
    private String taskTitle;
    private LocalDateTime taskDateAndTime;
    private Priority taskPriority;
    private Category taskCategory;


    private User user;
    private String description;


}
