package com.dizzy.mockito.integration;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



@SpringBootTest
@AutoConfigureMockMvc
public class AccountControllerTest {
	@Autowired
	private MockMvc mvc;
	

	@Test
	public void testPositive() throws Exception {
		 mvc.perform(MockMvcRequestBuilders
		  			.get("/myAccount1")
		  			.accept(MediaType.APPLICATION_JSON))
		  			.andDo(print())
		      .andExpect(status().isOk());
		
	}
	@Test
	public void testNagative() throws Exception {
		 mvc.perform(MockMvcRequestBuilders
		  			.get("/myAccount2")
		  			.accept(MediaType.APPLICATION_JSON))
		  			.andDo(print())
		      .andExpect(status().is4xxClientError());
		
	}
	
	

}
