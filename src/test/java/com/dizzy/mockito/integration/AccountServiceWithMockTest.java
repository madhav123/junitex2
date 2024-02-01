package com.dizzy.mockito.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;

import com.dizzy.model.Accounts;
import com.dizzy.repository.AccountsRepository;
import com.dizzy.service.AccountService;

@SpringBootTest
public class AccountServiceWithMockTest {
	
	@Autowired
	AccountService accountService;
	@MockBean
	AccountsRepository accountsRepository;

	@Test
	public void test1() {
		Accounts mockResponse = new Accounts();
		mockResponse.setBranchAddress("hyd");
		Mockito.when(accountsRepository.findByCustomerId(Mockito.anyInt())).thenReturn(mockResponse);
		Accounts account =accountService.getAccountDetails(0);
		System.out.println("account" + account.getBranchAddress());
		assertEquals("hyd", account.getBranchAddress());
	}
}



/**
 * public class AccountsRepository {
	
	Accounts findByCustomerId(int customerId){
	return null;
}
 * 
 */



 
