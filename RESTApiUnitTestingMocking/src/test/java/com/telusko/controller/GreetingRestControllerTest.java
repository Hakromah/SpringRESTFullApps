package com.telusko.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telusko.service.IGreetingService;
import com.telusko.service.Tourist;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
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

    @Test
    public void tesAddTouristInfo() throws Exception {
        Tourist tourist = new Tourist("Ram", 25, "Male", "India", "Bangalore");
        ObjectMapper mapper = new ObjectMapper();
        String cjson = mapper.writeValueAsString(tourist);// converts obj to json
        //Mocking
        Mockito.when(service.acceptTourist(ArgumentMatchers.any())).thenReturn(true);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/addtourist")
                .contentType(MediaType.APPLICATION_JSON)
                .content(cjson);
        //RequestObject
        ResultActions result = mockMvc.perform(requestBuilder);
        MvcResult mvcResult = result.andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        // Unit Testing
        assertEquals(200, status);
    }
}