package com.example.T1interview;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.beans.factory.annotation.Value;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class HttpRequestTest {

    @Value(value="${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void calculatingShouldReturnAllOnes() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +
                        "/api/calculate/str",
                String.class)).contains("'r': 1, 's': 1, 't': 1");
    }

    @Test
    public void calculatingHelloWorld() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +
                        "/api/calculate/Hello world!",
                String.class)).contains("'l': 3, 'o': 2, ' ': 1, '!': 1, 'r': 1, 'd': 1, 'e': 1, 'w': 1, 'h': 1");
    }

    @Test
    public void calculatingRussian() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +
                        "/api/calculate/str",
                String.class)).contains("'r': 1, 's': 1, 't': 1");
    }

    @Test
    public void calculatingShouldReturnTrue() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +
                        "/api/calculate/Привет мир!",
                String.class)).contains("'р': 2, 'и': 2, ' ': 1, '!': 1, 'в': 1, 'т': 1, 'е': 1, 'м': 1, 'п': 1");
    }
    @Test
    public void calculatingShouldReturnError404(){
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +
                        "/api/calculate//",
                String.class)).contains("404");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +
                        "/api/calculate/?",
                String.class)).contains("404");
    }

    @Test
    public void calculatingShouldReturnIncorrect() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port +
                        "/api/calculate/a;iu21qyhjkaguysuajajksgdjohakshd",
                String.class)).contains("'a': 1");

    }

}