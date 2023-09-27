package com.example.Cursor_HW12.web.rest;

import com.example.Cursor_HW12.entity.Product;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(6)
    public void testCreateProduct() throws Exception {
        Product product = new Product("A", 100.0, 3, 250.0);
        String productJson = objectMapper.writeValueAsString(product);

        mockMvc.perform(post("/product/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.code").value("A"))
                .andExpect(jsonPath("$.price").value(100.0))
                .andExpect(jsonPath("$.specialQuantity").value(3))
                .andExpect(jsonPath("$.specialPrice").value(250.0));
    }

    @Test
    @Order(1)
    public void testGetProductByCode() throws Exception {
        mockMvc.perform(get("/product/read/{code}", "C"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("C"))
                .andExpect(jsonPath("$.price").value(1.0))
                .andExpect(jsonPath("$.specialQuantity").value(6))
                .andExpect(jsonPath("$.specialPrice").value(5.0));
    }

    @Test
    @Order(3)
    public void testGetProductByCodeNotFound() throws Exception {
        mockMvc.perform(get("/product/read/{code}", "X"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Продукт не знайдено"));
    }

    @Test
    @Order(5)
    public void testGetAllProducts() throws Exception {
        mockMvc.perform(get("/product/read"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("B"))
                .andExpect(jsonPath("$[0].price").value(4.25))
                .andExpect(jsonPath("$[0].specialQuantity").value(0))
                .andExpect(jsonPath("$[0].specialPrice").value(0))
                .andExpect(jsonPath("$[1].code").value("C"))
                .andExpect(jsonPath("$[1].price").value(1.0))
                .andExpect(jsonPath("$[1].specialQuantity").value(6))
                .andExpect(jsonPath("$[1].specialPrice").value(5.0))
                .andExpect(jsonPath("$[2].code").value("D"))
                .andExpect(jsonPath("$[2].price").value(0.75))
                .andExpect(jsonPath("$[2].specialQuantity").value(0))
                .andExpect(jsonPath("$[2].specialPrice").value(0));
    }

    @Test
    @Order(2)
    public void testUpdateProduct() throws Exception {
        Product product = new Product("A", 150.0, 4, 300.0);
        String productJson = objectMapper.writeValueAsString(product);

        mockMvc.perform(put("/product/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("A"))
                .andExpect(jsonPath("$.price").value(150.0))
                .andExpect(jsonPath("$.specialQuantity").value(4))
                .andExpect(jsonPath("$.specialPrice").value(300.0));
    }

    @Test
    @Order(4)
    public void testDeleteProduct() throws Exception {
        mockMvc.perform(delete("/product/delete/{code}", "A"))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/product/read/{code}", "A"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Продукт не знайдено"));
    }
}
