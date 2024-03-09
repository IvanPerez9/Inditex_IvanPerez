package com.example.inditex.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class PricesTest {

	@Test
	void testGettersAndSetters() {
		Prices prices = new Prices();
		prices.setId(1L);
		prices.setBrandId(2L);
		prices.setStartDate(LocalDateTime.now());
		prices.setEndDate(LocalDateTime.now());
		prices.setPriceList(3);
		prices.setProductId(4L);
		prices.setPriority(5);
		prices.setPrice(new BigDecimal("6.50"));
		prices.setCurrency("EUR");

		assertEquals(1L, prices.getId());
		assertEquals(2L, prices.getBrandId());
		assertNotNull(prices.getStartDate());
		assertNotNull(prices.getEndDate());
		assertEquals(3, prices.getPriceList());
		assertEquals(4L, prices.getProductId());
		assertEquals(5, prices.getPriority());
		assertEquals(new BigDecimal("6.50"), prices.getPrice());
		assertEquals("EUR", prices.getCurrency());
	}

}
