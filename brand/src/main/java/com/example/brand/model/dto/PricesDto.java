package com.example.brand.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricesDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long brandId;
	
	private Long productId;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Europe/Madrid")
	private Date startDate;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "Europe/Madrid")
	private Date endDate;
	
	private Long priceList;
	
	private Double price;
	
	private String curr;
	
	public PricesDto(Long brandId, Long productId, Date startDate, Date endDate, Long priceList, Double price,
			String curr) {
		this.brandId = brandId;
		this.productId = productId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priceList = priceList;
		this.price = price;
		this.curr = curr;
	}
	
	public PricesDto() {}
	
}
