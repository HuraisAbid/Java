package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.HelloService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/{name}")
    public Message hello(@PathVariable String name) {
        return new Message(helloService.getMessage(name));
    }
}

