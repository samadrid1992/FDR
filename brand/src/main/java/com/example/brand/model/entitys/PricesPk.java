package com.example.brand.model.entitys;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class PricesPk implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="BRAND_ID")
	private Long brandId;
	
	@Column(name="PRICE_LIST")
	private Long priceList;
	
	@Column(name="PRODUCT_ID")
	private Long productId;

	public PricesPk(Long brandId, Long priceList, Long productId) {
		this.brandId = brandId;
		this.priceList = priceList;
		this.productId = productId;
	}
	
	public PricesPk() {}
}
