package com.example.inditex.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PricesControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testGetPrice() throws Exception {
		long brandId = 1L;
		long productId = 35455L;
		String date = "2020-06-15 00:00";

		mockMvc.perform(get("/price").param("brandId", String.valueOf(brandId)).param("date", date)
				.param("productId", String.valueOf(productId)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

	@Test
	void testGetAllPrices() throws Exception {
		mockMvc.perform(get("/prices/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}
}
