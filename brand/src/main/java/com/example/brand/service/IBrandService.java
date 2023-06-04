package com.example.brand.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.example.brand.model.dto.PricesDto;
import com.example.brand.model.entitys.Prices;
import com.example.brand.model.entitys.PricesPk;

public interface IBrandService {

	List<PricesDto> getPricesByFechaAndIdProductAndIdCadena(Date fecha, Long idProducto, Long idCadena);
	
	Prices getPricesByPk(PricesPk pk);
	
	void initBBDD() throws ParseException;
	
}
