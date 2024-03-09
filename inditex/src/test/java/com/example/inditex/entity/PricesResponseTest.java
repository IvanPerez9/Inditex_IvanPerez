package com.example.inditex.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class PricesResponseTest {

	@Test
	void testGettersAndSetters() {
		PricesResponseDto dto = new PricesResponseDto();
		Long productId = 1L;
		dto.setProductId(productId);
		Long brandId = 2L;
		dto.setBrandId(brandId);
		Integer priceList = 3;
		dto.setPriceList(priceList);
		Double price = 10.5;
		dto.setPrice(price);
		LocalDateTime startDate = LocalDateTime.of(2023, 4, 22, 10, 0, 0);
		dto.setStartDate(startDate);
		LocalDateTime endDate = LocalDateTime.of(2023, 4, 22, 12, 0, 0);
		dto.setEndDate(endDate);

		assertEquals(productId, dto.getProductId());
		assertEquals(brandId, dto.getBrandId());
		assertEquals(priceList, dto.getPriceList());
		assertEquals(price, dto.getPrice());
		assertEquals(startDate, dto.getStartDate());
		assertEquals(endDate, dto.getEndDate());
	}

}
