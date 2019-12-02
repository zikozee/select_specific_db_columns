package com.nativequery.mysqlnativequery.controller;

import com.nativequery.mysqlnativequery.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

    @Mock
    EmployeeService service;

    @InjectMocks
    EmployeeController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void list() throws Exception {
        mockMvc.perform(get("/mapper/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void dealerList() throws Exception {
        mockMvc.perform(get("/extractor/employees")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getDealer() throws Exception {
        mockMvc.perform(get("/employee/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}