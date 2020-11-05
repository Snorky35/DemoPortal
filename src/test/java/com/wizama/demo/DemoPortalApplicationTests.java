package com.wizama.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//@SpringBootTest
class DemoPortalApplicationTests extends DemoPortalTest {

//	@Test
//	void contextLoads() {
//	}
	
	@MockBean
	private ProductService productService;
	
	@Test
	void getProduct() throws Exception {
//		assertTrue("Test", true);
		String uri = "/api/v1/products/all";
		
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(null, "SquareOne", 499));
		products.add(new Product(null, "Chromacy", 29));
		products.add(new Product(null, "Crystal Bay", 49));
		products.add(new Product(null, "Dice Track", 69));
		
		Mockito.when(productService.findAll()).thenReturn(products);
		RequestBuilder builder = MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON_VALUE);
		
		assertNotNull(mvc);
		MvcResult mvcResult = mvc.perform(builder).andReturn();


		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Product[] productlist = super.mapFromJson(content, Product[].class);
		System.out.println(String.format("Taille de la liste retournée : %d", productlist.length));
//		log(String.format("Taille de la liste retournée : %d", productlist.length));
		assertTrue(productlist.length == 4);
	}


	
}
