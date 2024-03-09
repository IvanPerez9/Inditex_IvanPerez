package com.example.inditex.controller.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.inditex.controller.PricesController;
import com.example.inditex.entity.Prices;
import com.example.inditex.entity.PricesResponseDto;
import com.example.inditex.mapper.PricesMapper;
import com.example.inditex.service.PricesService;

/**
 * The Class PricesControllerImpl.
 */
@RestController
public class PricesControllerImpl implements PricesController {

	private PricesService pricesService;

	/**
	 * Instantiates a new prices controller impl.
	 *
	 * @param pricesService the prices service
	 */
	public PricesControllerImpl(PricesService pricesService) {
		super();
		this.pricesService = pricesService;
	}

	/**
	 * Gets the price.
	 *
	 * @param brandId   the brand id
	 * @param date      the date
	 * @param productId the product id
	 * @return the price
	 */
	@GetMapping("/price")
	public ResponseEntity<PricesResponseDto> getPrice(@RequestParam("brandId") Long brandId,
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String date,
			@RequestParam("productId") Long productId) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime localDateTime = LocalDateTime.parse(date, formatter);

		// optional
		Optional<Prices> optionalPrices = Optional
				.ofNullable(pricesService.findPrice(brandId, localDateTime, productId));

		// Mappper si no es vacio
		return optionalPrices.map((Prices prices) -> {
			PricesResponseDto response = PricesMapper.toResponseDto(prices);
			return ResponseEntity.ok(response);
		}).orElse(ResponseEntity.notFound().build());

	}

	/**
	 * Gets the all prices.
	 *
	 * @return the all prices
	 */
	@GetMapping("/prices/all")
	public ResponseEntity<List<PricesResponseDto>> getAllPrices() {

		// optional
		Optional<List<Prices>> optionalPricesList = Optional.ofNullable(pricesService.getAllPrices());

		// Mapper si no es null
		return optionalPricesList.map((List<Prices> list) -> {
			List<PricesResponseDto> responseDtoList = PricesMapper.toResponseDtoList(list);
			return ResponseEntity.ok(responseDtoList);
		}).orElse(ResponseEntity.notFound().build());
	}

}
