package com.example.taskManager.services;


import com.example.taskManager.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsers() {
        return List.of(User.builder()
                        .id(1)
                        .name("Sasha")
                        .build(),
                User.builder()
                        .id(2)
                        .name("Oleg")
                        .build(),
                User.builder()
                        .id(3)
                        .name("Roma")
                        .build());
    }

    @Override
    public User getUser(int id) {
        return User.builder()
                .id(1)
                .name("Sasha")
                .build();
    }

    @Override
    public User createUser(User newUser) {
        return User.builder()
                .id(2)
                .name("Oleg")
                .build();
    }

    @Override
    public User updateUser(User user) {
        return User.builder()
                .id(3)
                .name("Roma")
                .build();
    }

    @Override
    public void deleteUser(int id) {

    }
}
