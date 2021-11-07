package com.example.planner.model;

import com.example.planner.service.dto.UserView;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
//@ToString
public class User {

    @Id
    private UUID userId;
    private String name;

    @OneToMany(mappedBy = "user")
//    @JoinColumn(name = "task_id")
    private List<Task> tasks;

    public User(@NonNull String name) {
        this.userId = UUID.randomUUID();
        this.name = name;
    }

    public User() {
    }

    public UserView toView() {
        return new UserView(getUserId(), getName());
    }
}
