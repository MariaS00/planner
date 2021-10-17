package com.example.planner.main;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {

    @Id
    private UUID userId;
    private String name;

    @OneToMany  // cascade?
    @JoinColumn
    private List<Task> tasks;

    public User(@NonNull String name) {
        this.userId = UUID.randomUUID();
        this.name = name;
    }

    public User() {
    }
}
