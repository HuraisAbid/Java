package com.example.demo.unit;

import com.example.demo.service.HelloService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HelloServiceTest {

    private final HelloService service = new HelloService();

    @Test
    void testGetMessage() {
        String result = service.getMessage("DevOps");
        assertEquals("Hello, DevOps! Welcome to CI/CD pipeline.", result);
    }
}

