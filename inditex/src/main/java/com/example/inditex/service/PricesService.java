package com.example.inditex.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.inditex.entity.Prices;

/**
 * The Interface PricesService.
 */
public interface PricesService {

	/**
	 * Find price.
	 *
	 * @param brandId the brand id
	 * @param date the date
	 * @param productId the product id
	 * @return the prices
	 */
	Prices findPrice(Long brandId, LocalDateTime date, Long productId);
	
	/**
	 * Gets the all prices.
	 *
	 * @return the all prices
	 */
	List<Prices> getAllPrices();

}
