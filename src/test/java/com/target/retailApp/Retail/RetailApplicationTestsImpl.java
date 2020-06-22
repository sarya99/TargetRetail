package com.target.retailApp.Retail;

import java.io.IOException;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RetailApplicationTestsImpl extends RetailApplicationTests {


	   protected MockMvc mvc;
	 
	   @Autowired
	   WebApplicationContext webApplicationContext;

		
	   @Before
	   public void setUp() {
		   mvc =MockMvcBuilders.webAppContextSetup(webApplicationContext).build(); }
		 
	  
		/*
		 * @Before public void setup() { this.mvc = MockMvcBuilders.standaloneSetup(new
		 * RetailController()).build(); }
		 */
	  
	 protected String mapToJson(Object obj) throws JsonProcessingException {
		 ObjectMapper objectMapper = new ObjectMapper();
		 return objectMapper.writeValueAsString(obj);
	  }
	   
     protected <T> T mapFromJson(String json, Class<T> clazz)
		      throws JsonParseException, JsonMappingException, IOException {
		      
		      ObjectMapper objectMapper = new ObjectMapper();
		      return objectMapper.readValue(json, clazz);
		   }
		   
	   @Test
	   public void testFindByID() throws Exception {
	      String uri = "/products/"+ "5eef6c14606313744ccd6861";
			
			  MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
			  .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
			  
			  int status = mvcResult.getResponse().getStatus();
			 
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	     Product product = mapFromJson(content, Product.class);
	      assertTrue(product !=null);
	      }


	
	@Test
	public void testUpdateByID() throws Exception {
		   String uri = "/products/"+"5eef6c14606313744ccd6861";
		   Product product = new Product();
		   product.setId("5eef6c14606313744ccd6861");
		   product.setProductId("T001");
		   product.setProductName("HP EliteBook 670");
		   product.setPrice(new CurrentPrice("USD", "900"));
		   
		   String inputJson = mapToJson(product);
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
		      .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
		   
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
		   
		}
	

}
