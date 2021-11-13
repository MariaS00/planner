package com.example.planner.model;

import com.example.planner.service.dto.TaskView;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Task {

    @Id
    private UUID taskId;
    private String taskTitle;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // THH:mm
    private Date taskDate;
    @Enumerated(EnumType.STRING)
    private Priority taskPriority;
    @Enumerated(EnumType.STRING)
    private Category taskCategory;
    private String description;
//    @ManyToOne
//    private User user;

    public Task(@NotNull String taskTitle,
                @NonNull Date taskDate,
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

    public TaskView toView(){
        return new TaskView(getTaskId(),
                getTaskTitle(),
                getTaskDate(),
                getTaskPriority(),
                getTaskCategory(),
                getDescription());
    }

}
