package com.example.inditex.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.inditex.entity.Prices;

/**
 * The Interface PriceRepository.
 */
@Repository
public interface PricesRepository extends JpaRepository<Prices, Long> {

	/**
	 * Find first by brand id and start date less than equal and end date greater than equal and product id and priority order by priority desc.
	 * 
	 * Solo buscar 1
	 *
	 * @param brandId the brand id
	 * @param startDate the start date
	 * @param endDate the end date
	 * @param productId the product id
	 * @return the prices
	 */
	Prices findFirstByBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualAndProductIdOrderByPriorityDesc(
			Long brandId, LocalDateTime startDate, LocalDateTime endDate, Long productId);

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	List<Prices> findAll();

}
