package com.example.brand.model.mapper;

import com.example.brand.model.dto.PricesDto;
import com.example.brand.model.entitys.Prices;

public class PricesMapper {

	private PricesMapper() {}
	
	public static PricesDto transformToDto(Prices prices) {
		if(prices == null) {
			return null;
		}
		return new PricesDto(prices.getPricepk().getBrandId(),
							 prices.getPricepk().getProductId(), 
							 prices.getStartDate(), 
							 prices.getEndDate(), 
							 prices.getPricepk().getPriceList(),
							 prices.getPrice(),
							 prices.getCurr());
	}
	
}
