package com.example.taskManager.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Task {
    private int taskId;
    private String taskName;
    private String taskStatus;
    private LocalDateTime startTime;
    private LocalDateTime expiredTime;
    private String description;
}
