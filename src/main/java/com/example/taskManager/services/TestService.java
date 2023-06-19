package com.example.taskManager.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestService {

    public String getBooks() {
        return "Hello World";
    }

    public String createBooks() {
        return "Hello BOOKS";
    }
}
