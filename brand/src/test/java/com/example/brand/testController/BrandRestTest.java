package com.example.brand.testController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.brand.model.dto.PricesEntradaDto;
import com.example.brand.rest.BrandRest;
import com.example.brand.service.IBrandService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BrandRestTest {

	private MockMvc mockMvc;
	
	@InjectMocks
	private BrandRest brandRest;
	
	@Mock
	IBrandService brandService;
	
	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(brandRest).build();
	}

	@Test
	void getPricesBody() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		PricesEntradaDto entrada = new PricesEntradaDto(1L, 35455L, sdf.parse("14-06-2020 10:00:00"));
		
		Mockito.when(brandService
					.getPricesByFechaAndIdProductAndIdCadena(Mockito.any(Date.class), Mockito.any(Long.class), Mockito.any(Long.class)))
				.thenReturn(new ArrayList<>());
		
		this.mockMvc.perform(get("/brandRest/getpricesbody")
								.content(asJsonString(entrada))
								.contentType(MediaType.APPLICATION_JSON)
								.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andReturn();
	}
	
	@Test
	void getPrices() throws Exception {
		Mockito.when(brandService
					.getPricesByFechaAndIdProductAndIdCadena(Mockito.any(Date.class), Mockito.any(Long.class), Mockito.any(Long.class)))
				.thenReturn(new ArrayList<>());
		
		this.mockMvc.perform(get("/brandRest/getprices/35455/1/1592128800000"))
					.andExpect(status().isOk())
					.andReturn();
	}
	
	
	private static String asJsonString(final Object obj) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return objectMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
