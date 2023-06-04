package com.example.brand.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.brand.exception.FaltanParametrosException;
import com.example.brand.model.dto.PricesDto;
import com.example.brand.model.dto.PricesEntradaDto;
import com.example.brand.service.IBrandService;

@RestController
@RequestMapping (value="/brandRest")
public class BrandRest {

	@Autowired
	private IBrandService service;
	
	@GetMapping(value="/getprices/{idProducto}/{idCadena}/{longDate}")
	public List<PricesDto> getPrices(@PathVariable Long idProducto, @PathVariable Long idCadena, @PathVariable Long longDate) {
		return service.getPricesByFechaAndIdProductAndIdCadena(new Date(longDate), idProducto, idCadena);
	}
	
	@GetMapping(value="/getpricesbody")
	public List<PricesDto> getPricesBody(@RequestBody PricesEntradaDto pricesEntrada) throws FaltanParametrosException {
		if(pricesEntrada == null) {
			throw new FaltanParametrosException();
		}
		if(pricesEntrada.getBrandId() == null) {
			throw new FaltanParametrosException("brandId");
		}
		if(pricesEntrada.getDate() == null) {
			throw new FaltanParametrosException("date");
		}
		if(pricesEntrada.getProductId() == null) {
			throw new FaltanParametrosException("productId");
		}
		return service.getPricesByFechaAndIdProductAndIdCadena(pricesEntrada.getDate(), pricesEntrada.getProductId(), pricesEntrada.getBrandId());
	}
}
