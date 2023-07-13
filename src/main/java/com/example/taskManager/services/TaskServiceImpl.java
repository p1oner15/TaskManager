package com.example.taskManager.services;

import com.example.taskManager.domain.Task;
import com.example.taskManager.domain.User;
import com.example.taskManager.repository.TaskRepository;
import com.example.taskManager.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTask(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public Task createTask(Task newTask) {
        User customer = newTask.getCustomer();
        if (customer != null) {
            newTask.setCustomer(customer); // Установка связи задачи с пользователем
            customer.getTask().add(newTask); // Добавление задачи пользователю
        }
        return taskRepository.save(newTask);
    }

    @Override
    public Task updateTask(Task updatedTask) {
        return taskRepository.save(updatedTask);
    }

    @Override
    public void deleteTask(int id) {
       taskRepository.deleteById(id);
    }
}
