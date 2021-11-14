package com.example.planner.model;

import com.example.planner.service.dto.TaskView;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    //@DateTimeFormat(pattern = "yyyy-MM-dd") // THH:mm
   // @DateTimeFormat(pattern = "@code yyyy-MM-dd'T'HH:mm:ss.SSSZ") // THH:mm

    private LocalDateTime taskDate;
    @Enumerated(EnumType.STRING)
    private Priority taskPriority;
    @Enumerated(EnumType.STRING)
    private Category taskCategory;
    private String description;
//    @ManyToOne
//    private User user;


    public String getTaskDateAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        if( taskDate!=null) {
            return taskDate.format(formatter);

        }
        return null;
    }

    public void setTaskDateAsString(String value) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        taskDate = LocalDateTime.parse(value, formatter);
    }
    public Task(@NotNull String taskTitle,
                @NonNull LocalDateTime taskDate,
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
