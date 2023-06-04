package com.example.brand.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.brand.model.entitys.Prices;
import com.example.brand.model.entitys.PricesPk;

public interface IBrandRepository extends CrudRepository<Prices, PricesPk> {

	@Query("SELECT p FROM Prices p WHERE :fecha BETWEEN p.startDate and p.endDate and p.pricepk.brandId = :brandId and p.pricepk.productId = :productId")
	List<Prices> findByBrandIdAndFechaAndProductId(@Param("brandId") Long brandId,@Param("fecha") Date fecha, @Param("productId") Long productId);
	
}
