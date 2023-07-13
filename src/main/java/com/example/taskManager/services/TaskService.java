package com.example.taskManager.services;

import com.example.taskManager.domain.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();

    Task getTask(int id);

    Task createTask(Task newTask);

    Task updateTask(Task updatedTask);

    void deleteTask(int id);

}
