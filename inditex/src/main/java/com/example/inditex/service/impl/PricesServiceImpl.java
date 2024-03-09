package com.example.inditex.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.inditex.entity.Prices;
import com.example.inditex.repository.PricesRepository;
import com.example.inditex.service.PricesService;

/**
 * The Class PricesServiceImpl.
 */
@Service
public class PricesServiceImpl implements PricesService {

	private PricesRepository pricesRepository;

	/**
	 * Instantiates a new prices service impl.
	 *
	 * @param pricesRepository the prices repository
	 */
	public PricesServiceImpl(PricesRepository pricesRepository) {
		super();
		this.pricesRepository = pricesRepository;
	}

	/**
	 * Find price.
	 *
	 * @param brandId   the brand id
	 * @param date      the date
	 * @param productId the product id
	 * @return the prices
	 */
	public Prices findPrice(Long brandId, LocalDateTime date, Long productId) {
		Prices price = pricesRepository
				.findFirstByBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdAndPriorityOrderByPriorityDesc(
						brandId, date, date, productId, 0);

		return Optional.ofNullable(price).orElse(null);
	}

	/**
	 * Gets the all prices.
	 *
	 * @return the all prices
	 */
	public List<Prices> getAllPrices() {
		List<Prices> prices = pricesRepository.findAll();
		return Optional.ofNullable(prices).orElse(null);
	}

}
