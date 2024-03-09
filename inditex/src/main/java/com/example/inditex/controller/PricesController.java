package com.example.inditex.controller;

import org.springframework.http.ResponseEntity;

import com.example.inditex.entity.PricesResponseDto;

/**
 * The Interface PricesController.
 */
public interface PricesController {

	/**
	 * Gets the price.
	 *
	 * @param brandId the brand id
	 * @param date the date
	 * @param productId the product id
	 * @return the price
	 */
	public ResponseEntity<PricesResponseDto> getPrice(Long brandId, String date, Long productId);

}
