package com.example.planner.main;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    public User(@NonNull String name) {
        this.userId = UUID.randomUUID();
        this.name = name;
    }

    public User() {
    }
}
