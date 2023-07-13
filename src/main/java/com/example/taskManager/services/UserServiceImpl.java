package com.example.taskManager.services;


import com.example.taskManager.domain.Task;
import com.example.taskManager.domain.User;
import com.example.taskManager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final TaskService taskService;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }



    @Override
    public User addTask(int id, Task newTask) {
        // Найти Юзера по ID
        //поменять или добавить ему задачи
        // сохранить задачу и обновленного юзера
        // вернуть usera
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            User user = byId.get();
            Task task = taskService.createTask(newTask);
            List<Task> taskList = user.getTask();
            taskList.add(task);
            user.setTask(taskList);
            return userRepository.save(user);
        } else {
            throw new RuntimeException("Юзер с таким айди не найден");
        }
    }
}
