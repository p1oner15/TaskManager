package com.example.taskManager.controller;

import com.example.taskManager.domain.Task;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequestMapping("tasks")
@RestController
@AllArgsConstructor
public class TaskController {
    private List<Task> tasks = List.of();
    private Task task;

    // Получение списка задач и данных о них
    @GetMapping
    public List<Task> getTasks() {
        return tasks;
    }

    // Получение одной конкретной задачи по её ID
    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        Optional<Task> optionalTask = tasks.stream()
                .filter(task -> task.getTaskId() == id)
                .findFirst();

        return optionalTask.orElse(null);
    }

    // Создание задачи
    @PostMapping("tasks/createTask")
    public void createTask(@RequestBody Task newTask) {
        tasks.add(newTask);
    }

    // Обновление данных задачи по ID
    @PutMapping("/{id}")
    public void updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        Optional<Task> optionalTask = tasks.stream()
                .filter(task -> task.getTaskId() == id)
                .findFirst();

        if (optionalTask.isPresent()) {
            Task taskToUpdate = optionalTask.get();
            // Обновляем поля задачи
            taskToUpdate.setTaskName(updatedTask.getTaskName());
            taskToUpdate.setTaskStatus(updatedTask.getTaskStatus());
            taskToUpdate.setStartTime(updatedTask.getStartTime());
            taskToUpdate.setExpiredTime(updatedTask.getExpiredTime());
            taskToUpdate.setDescription(updatedTask.getDescription());
        }
    }

    // Удаление задачи по ID
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        tasks.removeIf(task -> task.getTaskId() == id);
    }
}
