package com.example.taskManager.services;

import com.example.taskManager.domain.Task;
import com.example.taskManager.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(int id);

    User createUser(User newUser);

    User updateUser(User user);

    void deleteUser(int id);

    User addTask(int id, Task newTask);
}
