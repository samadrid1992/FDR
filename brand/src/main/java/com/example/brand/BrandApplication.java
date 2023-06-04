package com.example.brand;

import java.text.ParseException;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.brand.service.IBrandService;

@SpringBootApplication
public class BrandApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(BrandApplication.class, args);
		try {
			context.getBean(IBrandService.class).initBBDD();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
