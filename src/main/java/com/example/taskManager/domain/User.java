package com.example.taskManager.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class User {
    private int id;
    private String name;
    private Task task;
}
