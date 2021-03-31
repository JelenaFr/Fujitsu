package com.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FeedbackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void contextLoads() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }

    @Test
    public void createFeedback() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/")
                .param("userName", "Melania")
                .param("email", "melania@exmaple.com")
                .param("feedbackText", "some text")
                .param("categories", String.valueOf(4))  ;
        this.mockMvc.perform(builder)
                .andExpect(status().isFound());
    }

    @Test
    public void createFeedback_notPassValidation() throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/")
                .param("userName", "")
                .param("email", "melania@exmaple.com")
                .param("feedbackText", "some text")
                .param("categories", String.valueOf(4))  ;
        this.mockMvc.perform(builder)
                .andExpect(status().isOk());
    }


}


