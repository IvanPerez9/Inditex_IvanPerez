package com.example.inditex.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.inditex.entity.Prices;
import com.example.inditex.repository.PricesRepository;
import com.example.inditex.service.impl.PricesServiceImpl;

class PricesServiceTest {

	@Mock
	private PricesRepository pricesRepository;

	@InjectMocks
	private PricesServiceImpl pricesService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
		this.pricesService = new PricesServiceImpl(pricesRepository);
	}

	@Test
	void testFindPrice() {
		// datos
		Long brandId = 1L;
		LocalDateTime date = LocalDateTime.now();
		Long productId = 2L;
		Prices expectedPrice = new Prices();

		// when
		when(pricesRepository
				.findFirstByBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdOrderByPriorityDesc(
						brandId, date, date, productId))
				.thenReturn(expectedPrice);

		// then
		Prices actualPrice = pricesService.findPrice(brandId, date, productId);

		// assert
		assertEquals(expectedPrice, actualPrice);
	}

	@Test
	void testFindPrice_whenNoPrices() {
		// datos
		Long brandId = 1L;
		LocalDateTime date = LocalDateTime.now();
		Long productId = 2L;
		Prices expectedPrice = new Prices();

		// when
		when(pricesRepository
				.findFirstByBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdOrderByPriorityDesc(
						brandId, date, date, productId))
				.thenReturn(expectedPrice);

		// then
		Prices actualPrice = pricesService.findPrice(brandId, date, productId);

		// assert
		assertEquals(null, actualPrice.getBrandId());
	}

	@Test
	void testFindPrice_whenPricesNull() {
		// datos
		Long brandId = 1L;
		LocalDateTime date = LocalDateTime.now();
		Long productId = 2L;

		// when
		when(pricesRepository
				.findFirstByBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdOrderByPriorityDesc(
						brandId, date, date, productId))
				.thenReturn(null);

		// then
		Prices actualPrice = pricesService.findPrice(brandId, date, productId);

		// assert
		assertEquals(null, actualPrice);
	}

	@Test
	void testGetAllPrices() {
		// datos
		Prices price1 = new Prices();
		Prices price2 = new Prices();
		List<Prices> expectedPrices = Arrays.asList(price1, price2);

		// when
		when(pricesRepository.findAll()).thenReturn(expectedPrices);

		// then
		List<Prices> actualPrices = pricesService.getAllPrices();

		// assert
		assertEquals(expectedPrices.size(), actualPrices.size());
		assertTrue(actualPrices.containsAll(expectedPrices));
	}

}
