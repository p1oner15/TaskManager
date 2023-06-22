package com.example.taskManager.controller;

import com.example.taskManager.domain.User;
import com.example.taskManager.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("users")
@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    // Получить список пользователей
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // Получить пользователя по ID
    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    // Создать пользователя
    @PostMapping()
    public User createUser(@RequestBody User newUser) {
        return userService.createUser(newUser);
    }

    // Обновить данные о пользователе по ID
    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    // Удалить пользователя по ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
