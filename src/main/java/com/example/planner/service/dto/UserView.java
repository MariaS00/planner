package com.example.planner.service.dto;

import lombok.Value;

import java.util.UUID;

@Value
public class UserView {

    UUID userId;
    String name;
}
