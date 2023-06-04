package com.example.brand.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.brand.model.dto.PricesDto;
import com.example.brand.model.entitys.Prices;
import com.example.brand.model.entitys.PricesPk;
import com.example.brand.repository.IBrandRepository;
import com.example.brand.service.IBrandService;

@Service
public class BrandService implements IBrandService {

	@Autowired
	private IBrandRepository repository;

	@Override
	public List<PricesDto> getPricesByFechaAndIdProductAndIdCadena(Date fecha, Long idProducto, Long idCadena) {
		return repository.findByBrandIdAndFechaAndProductId(idCadena, fecha, idProducto).stream().map(p -> new PricesDto(p.getPricepk().getBrandId(), p.getPricepk().getProductId(), p.getStartDate(), p.getEndDate(), p.getPricepk().getPriceList(), p.getPrice(), p.getCurr())).toList();
	}

	@Override
	public Prices getPricesByPk(PricesPk pk) {
		return repository.findById(pk).orElse(null);
	}

	@Override
	public void initBBDD() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
		repository.save(new Prices(sdf.parse("2020-06-14-00.00.00"), 
									sdf.parse("2020-12-31-23.59.59"), 
									new PricesPk(1L, 1L, 35455L), 
									0L, 
									35.50, 
									"EUR"));
		repository.save(new Prices(sdf.parse("2020-06-14-15.00.00"), 
				sdf.parse("2020-06-14-18.30.00"), 
				new PricesPk(1L, 2L, 35455L), 
				1L, 
				25.45, 
				"EUR"));
		repository.save(new Prices(sdf.parse("2020-06-15-00.00.00"), 
				sdf.parse("2020-06-15-11.00.00"), 
				new PricesPk(1L, 3L, 35455L), 
				1L, 
				30.50, 
				"EUR"));
		repository.save(new Prices(sdf.parse("2020-06-15-16.00.00"), 
				sdf.parse("2020-12-31-23.59.59"), 
				new PricesPk(1L, 4L, 35455L), 
				1L, 
				38.95, 
				"EUR"));
	}

}
