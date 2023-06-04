package com.example.brand.model.entitys;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="PRICES")
@Getter
@Setter
public class Prices implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name="START_DATE")
	private Date startDate;
	
	@Column(name="END_DATE")
	private Date endDate;
	
	@EmbeddedId
	private PricesPk pricepk;
	
	@Column(name="PRIORITY")
	private Long priority;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="CURR")
	private String curr;

	public Prices(Date startDate, Date endDate, PricesPk pricepk, Long priority, Double price, String curr) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.pricepk = pricepk;
		this.priority = priority;
		this.price = price;
		this.curr = curr;
	}
	
	public Prices() {}
}
