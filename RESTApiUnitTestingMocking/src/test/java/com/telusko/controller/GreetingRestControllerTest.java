package com.telusko.controller;

import com.telusko.service.IGreetingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(GreetingRestController.class)
class GreetingRestControllerTest {

    @MockBean
    private IGreetingService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void generateGreetings() throws Exception {
        // Mockito
        Mockito.when(service.generateGreetings()).thenReturn("Hello My friend!");

        // RequestObject
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/greet");
        ResultActions result = mockMvc.perform(requestBuilder);
        MvcResult mvcResult = result.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        // Unit Testing
        assertEquals(200, status);
    }
}