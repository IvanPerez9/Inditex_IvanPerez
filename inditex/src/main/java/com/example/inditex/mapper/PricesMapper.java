package com.example.inditex.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.inditex.entity.Prices;
import com.example.inditex.entity.PricesResponseDto;

/**
 * The Class PricesMapper.
 */
public class PricesMapper {

	/**
	 * Instantiates a new prices mapper.
	 */
	private PricesMapper() {

	}

	/**
	 * To response dto.
	 *
	 * @param prices the prices
	 * @return the prices response dto
	 */
	public static PricesResponseDto toResponseDto(Prices prices) {
		// check nulos, defecto 0
		PricesResponseDto response = new PricesResponseDto();
		response.setBrandId(Optional.ofNullable(prices.getBrandId()).orElse(0L));
	    response.setProductId(Optional.ofNullable(prices.getProductId()).orElse(0L));
	    response.setPriceList(Optional.ofNullable(prices.getPriceList()).orElse(0));
		response.setStartDate(prices.getStartDate());
		response.setEndDate(prices.getEndDate());
		response.setPrice(Optional.ofNullable(prices.getPrice()).map(BigDecimal::doubleValue).orElse(0.0));
		return response;
	}

	/**
	 * To response dto list.
	 *
	 * @param pricesList the prices list
	 * @return the list
	 */
	public static List<PricesResponseDto> toResponseDtoList(List<Prices> pricesList) {
		return pricesList.stream().map(PricesMapper::toResponseDto).collect(Collectors.toList());
	}

}
