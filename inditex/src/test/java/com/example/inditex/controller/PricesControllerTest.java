package com.example.inditex.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.inditex.controller.impl.PricesControllerImpl;
import com.example.inditex.entity.Prices;
import com.example.inditex.entity.PricesResponseDto;
import com.example.inditex.service.PricesService;

class PricesControllerTest {

	@InjectMocks
	private PricesControllerImpl pricesController;
	@Mock
	private PricesService pricesService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testGetPriceAt10AMOn14th() {
		// datos
		long brandId = 1L;
		long productId = 35455L;
		LocalDateTime dateTime = LocalDateTime.parse("2023-04-14 10:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		Prices prices = new Prices();
		prices.setBrandId(brandId);
		prices.setProductId(productId);
		prices.setPriceList(1);
		prices.setStartDate(LocalDateTime.parse("2023-03-26 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setEndDate(LocalDateTime.parse("2023-04-15 11:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setPrice(new BigDecimal(35.50));
		// when
		when(pricesService.findPrice(brandId, dateTime, productId)).thenReturn(prices);
		PricesResponseDto expectedResponse = new PricesResponseDto();
		expectedResponse.setBrandId(brandId);
		expectedResponse.setProductId(productId);
		expectedResponse.setPriceList(prices.getPriceList());
		expectedResponse.setStartDate(prices.getStartDate());
		expectedResponse.setEndDate(prices.getEndDate());
		expectedResponse.setPrice(prices.getPrice().doubleValue());

		// then
		ResponseEntity<PricesResponseDto> response = pricesController.getPrice(brandId, "2023-04-14 10:00", productId);

		// assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedResponse.getPrice(), response.getBody().getPrice());
	}

	@Test
	void testGetPriceAt4PMOn14th() {
		// datos
		long brandId = 1L;
		long productId = 35455L;
		LocalDateTime dateTime = LocalDateTime.parse("2023-04-14 16:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		Prices prices = new Prices();
		prices.setBrandId(brandId);
		prices.setProductId(productId);
		prices.setPriceList(2);
		prices.setStartDate(LocalDateTime.parse("2023-04-01 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setEndDate(LocalDateTime.parse("2023-06-30 23:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setPrice(new BigDecimal(25.45));
		when(pricesService.findPrice(brandId, dateTime, productId)).thenReturn(prices);
		PricesResponseDto expectedResponse = new PricesResponseDto();
		expectedResponse.setBrandId(brandId);
		expectedResponse.setProductId(productId);
		expectedResponse.setPriceList(prices.getPriceList());
		expectedResponse.setStartDate(prices.getStartDate());
		expectedResponse.setEndDate(prices.getEndDate());
		expectedResponse.setPrice(prices.getPrice().doubleValue());

		// then
		ResponseEntity<PricesResponseDto> response = pricesController.getPrice(brandId, "2023-04-14 16:00", productId);

		// assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedResponse.getPrice(), response.getBody().getPrice());
	}

	@Test
	void testGetPriceAt9PMOn14th() {
		// datos
		long brandId = 1L;
		long productId = 35455L;
		LocalDateTime dateTime = LocalDateTime.parse("2023-04-14 21:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		Prices prices = new Prices();
		prices.setBrandId(brandId);
		prices.setProductId(productId);
		prices.setPriceList(1);
		prices.setStartDate(LocalDateTime.parse("2023-03-26 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setEndDate(LocalDateTime.parse("2023-04-15 11:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setPrice(new BigDecimal(30.50));
		when(pricesService.findPrice(brandId, dateTime, productId)).thenReturn(prices);
		PricesResponseDto expectedResponse = new PricesResponseDto();
		expectedResponse.setBrandId(brandId);
		expectedResponse.setProductId(productId);
		expectedResponse.setPriceList(prices.getPriceList());
		expectedResponse.setStartDate(prices.getStartDate());
		expectedResponse.setEndDate(prices.getEndDate());
		expectedResponse.setPrice(prices.getPrice().doubleValue());

		// then
		ResponseEntity<PricesResponseDto> response = pricesController.getPrice(brandId, "2023-04-14 21:00", productId);

		// assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedResponse.getPrice(), response.getBody().getPrice());
	}

	@Test
	void testGetPriceAt10AMOn15th() {
		// datos
		long brandId = 1L;
		long productId = 35455L;
		LocalDateTime dateTime = LocalDateTime.parse("2023-04-15 10:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		Prices prices = new Prices();
		prices.setBrandId(brandId);
		prices.setProductId(productId);
		prices.setPriceList(1);
		prices.setStartDate(LocalDateTime.parse("2023-03-26 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setEndDate(LocalDateTime.parse("2023-04-15 11:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setPrice(new BigDecimal(35.50));
		when(pricesService.findPrice(brandId, dateTime, productId)).thenReturn(prices);
		PricesResponseDto expectedResponse = new PricesResponseDto();
		expectedResponse.setBrandId(brandId);
		expectedResponse.setProductId(productId);
		expectedResponse.setPriceList(prices.getPriceList());
		expectedResponse.setStartDate(prices.getStartDate());
		expectedResponse.setEndDate(prices.getEndDate());
		expectedResponse.setPrice(prices.getPrice().doubleValue());

		// then
		ResponseEntity<PricesResponseDto> response = pricesController.getPrice(brandId, "2023-04-15 10:00", productId);

		// assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedResponse.getPrice(), response.getBody().getPrice());
	}

	@Test
	void testGetPriceAt9PMOn16th() {
		// datos
		long brandId = 1L;
		long productId = 35455L;
		LocalDateTime dateTime = LocalDateTime.parse("2023-04-16 21:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		Prices prices = new Prices();
		prices.setBrandId(brandId);
		prices.setProductId(productId);
		prices.setPriceList(3);
		prices.setStartDate(LocalDateTime.parse("2023-04-01 15:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setEndDate(LocalDateTime.parse("2023-04-30 23:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		prices.setPrice(new BigDecimal(25.45));
		// when
		when(pricesService.findPrice(brandId, dateTime, productId)).thenReturn(prices);
		PricesResponseDto expectedResponse = new PricesResponseDto();
		expectedResponse.setBrandId(brandId);
		expectedResponse.setProductId(productId);
		expectedResponse.setPriceList(prices.getPriceList());
		expectedResponse.setStartDate(prices.getStartDate());
		expectedResponse.setEndDate(prices.getEndDate());
		expectedResponse.setPrice(prices.getPrice().doubleValue());

		// then
		ResponseEntity<PricesResponseDto> response = pricesController.getPrice(brandId, "2023-04-16 21:00", productId);

		// assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedResponse.getPrice(), response.getBody().getPrice());
	}

	@Test
	void testGetPriceWhenPriceIsNull() {
		// datos
		long brandId = 1L;
		long productId = 35455L;
		LocalDateTime dateTime = LocalDateTime.parse("2023-04-14 10:00",
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		// when
		when(pricesService.findPrice(brandId, dateTime, productId)).thenReturn(null);

		// then
		ResponseEntity<PricesResponseDto> response = pricesController.getPrice(brandId, "2023-04-14 10:00", productId);

		// assert
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void testGetAllPricesWhenPricesNull() {
		// when
		when(pricesService.getAllPrices()).thenReturn(null);

		// then
		ResponseEntity<List<PricesResponseDto>> response = pricesController.getAllPrices();

		// assert
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void testGetAllPrices() {
		//
		long brandId = 1L;
		long productId = 35455L;
		Prices price1 = new Prices();
		price1.setBrandId(brandId);
		price1.setProductId(productId);
		price1.setPriceList(2);
		price1.setStartDate(LocalDateTime.parse("2023-04-01 00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		price1.setEndDate(LocalDateTime.parse("2023-06-30 23:59", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		price1.setPrice(new BigDecimal(25.45));

		Prices price2 = new Prices();
		List<Prices> expectedPrices = Arrays.asList(price1, price2);

		// when
		when(pricesService.getAllPrices()).thenReturn(expectedPrices);

		// then
		ResponseEntity<List<PricesResponseDto>> response = pricesController.getAllPrices();

		// assert
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedPrices.size(), response.getBody().size());
	}

}