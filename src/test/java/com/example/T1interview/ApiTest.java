package com.example.T1interview;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class ApiTest  {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testApiSingle() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculate/a"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("[\"'a': 1\"]")).andDo(document("home"));
    }

    @Test
    public void testApiEmpty() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculate/"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andDo(document("home"));
    }
    @Test
    public void testApiAvailability() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/calculate/Hello world!"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().json("[\"'l': 3, 'o': 2, ' ': 1, '!': 1, 'r': 1, 'd': 1, 'e': 1, 'w': 1, 'h': 1\"]")).andDo(document("home"));
    }
}
