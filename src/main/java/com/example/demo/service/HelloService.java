package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getMessage(String name) {
        return "Hello, " + name + "! Welcome to CI/CD pipeline.";
    }
}

