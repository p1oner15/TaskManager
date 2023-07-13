package com.example.taskManager.controller;

import com.example.taskManager.domain.Task;
import com.example.taskManager.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("tasks")
@RestController
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    // Получение списка задач и данных о них
    @GetMapping
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    // Получение одной конкретной задачи по её ID
    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.getTask(id);
    }

    // Создание задачи
    @PostMapping()
    public Task createTask(@RequestBody Task newTask) {
        return taskService.createTask(newTask);
    }

    // Обновление данных задачи по ID
    @PutMapping("/{id}")
    public Task updateTask(@RequestBody Task updatedTask) {
        return taskService.updateTask(updatedTask);
    }

    // Удаление задачи по ID
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
