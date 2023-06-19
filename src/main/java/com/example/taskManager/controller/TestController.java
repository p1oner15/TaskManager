package com.example.taskManager.controller;

import com.example.taskManager.services.TestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("books")
@RestController
@AllArgsConstructor
public class TestController {

    private TestService testService;

    @GetMapping()
    public String getBooks() {
        return testService.getBooks();
    }

    @PostMapping()
    public String createBooks() {
        return testService.createBooks();
    }
}
