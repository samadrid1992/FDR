package com.example.brand.model.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PricesEntradaDto implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonProperty("brandId")
	private Long brandId;
	
	@JsonProperty("productId")
	private Long productId;
	
	@JsonProperty("date")
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss", timezone ="Europe/Madrid")
	private Date date;
	
	public PricesEntradaDto(Long brandId, Long productId, Date date) {
		this.brandId = brandId;
		this.productId = productId;
		this.date = date;
	}
	
	public PricesEntradaDto() {}
	
}
