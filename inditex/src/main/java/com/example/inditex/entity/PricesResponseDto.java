package com.example.inditex.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class PricesResponseDto.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PricesResponseDto {

	private Long productId;

	private Long brandId;

	private Integer priceList;

	private Double price;

	private LocalDateTime startDate;

	private LocalDateTime endDate;

}
