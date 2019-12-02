package com.nativequery.mysqlnativequery.controller;

import com.nativequery.mysqlnativequery.service.DealerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class DealerControllerTest {

    @Mock
    DealerService service;

    @InjectMocks
    DealerController controller;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    void list() throws Exception {
        mockMvc.perform(get("/mapper/dealers")
        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void dealerList() throws Exception {
        mockMvc.perform(get("/extractor/dealers")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getDealer() throws Exception {
        mockMvc.perform(get("/dealer/100100")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}