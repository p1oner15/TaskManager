package com.example.taskManager.services;

import com.example.taskManager.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(@PathVariable int id);

    User createUser(@RequestBody User newUser);

    User updateUser(@RequestBody User user);

    void deleteUser(@PathVariable int id);
}
