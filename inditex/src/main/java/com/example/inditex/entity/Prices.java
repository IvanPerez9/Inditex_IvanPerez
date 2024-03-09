package com.example.inditex.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The Class Prices.
 */
@Entity
@Table(name = "PRICES")
public class Prices {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "BRAND_ID")
	private Long brandId;

	@Column(name = "START_DATE")
	private LocalDateTime startDate;

	@Column(name = "END_DATE")
	private LocalDateTime endDate;

	@Column(name = "PRICE_LIST")
	private Integer priceList;

	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRIORITY")
	private Integer priority;

	@Column(name = "PRICE")
	private BigDecimal price;

	@Column(name = "CURR")
	private String currency;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the brand id.
	 *
	 * @return the brand id
	 */
	public Long getBrandId() {
		return brandId;
	}

	/**
	 * Sets the brand id.
	 *
	 * @param brandId the new brand id
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	/**
	 * Gets the start date.
	 *
	 * @return the start date
	 */
	public LocalDateTime getStartDate() {
		return startDate;
	}

	/**
	 * Sets the start date.
	 *
	 * @param startDate the new start date
	 */
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	/**
	 * Gets the end date.
	 *
	 * @return the end date
	 */
	public LocalDateTime getEndDate() {
		return endDate;
	}

	/**
	 * Sets the end date.
	 *
	 * @param endDate the new end date
	 */
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	/**
	 * Gets the price list.
	 *
	 * @return the price list
	 */
	public Integer getPriceList() {
		return priceList;
	}

	/**
	 * Sets the price list.
	 *
	 * @param priceList the new price list
	 */
	public void setPriceList(Integer priceList) {
		this.priceList = priceList;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	/**
	 * Gets the priority.
	 *
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * Sets the priority.
	 *
	 * @param priority the new priority
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}