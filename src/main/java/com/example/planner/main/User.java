package com.example.planner.main;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table
public class User {

    @Id
    private UUID userId;
    private String name;
}
