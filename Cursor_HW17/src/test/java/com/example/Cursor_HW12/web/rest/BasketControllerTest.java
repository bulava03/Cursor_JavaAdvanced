package com.example.Cursor_HW12.web.rest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test-basket.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BasketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCalculateBasketValue() throws Exception {
        String basket = "AAABBCCCCD";
        double expectedTotalCost = 16.25;

        mockMvc.perform(get("/basket/calculate/{basket}", basket))
                .andExpect(status().isOk())
                .andExpect(content().string(Double.toString(expectedTotalCost)))
                .andReturn();
    }

    @Test
    void testCalculateBasketValueInvalidBasket() throws Exception {
        String basket = "XYZ";
        String expectedErrorMessage = "Під час виконання запиту сталася помилка";

        mockMvc.perform(get("/basket/calculate/{basket}", basket))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(expectedErrorMessage));
    }

}
