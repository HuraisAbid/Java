package com.example.demo.integration;

import com.example.demo.DemoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = DemoApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate rest = new TestRestTemplate();

    @Test
    void testHelloEndpoint() {
        String url = "http://localhost:" + port + "/api/hello/John";
        var response = rest.getForObject(url, String.class);
        assertTrue(response.contains("Hello, John!"));
    }
}

