package com.dizzy.mockito.integration;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dizzy.repository.AccountsRepository;
import com.dizzy.service.AccountService;

@SpringBootTest
public class AccountServiceExceptionCaseTest {

	@Autowired
	AccountService accountService;

	@MockBean
	private AccountsRepository accountsRepository;
	@Test
	public void test1() {
		
		 doThrow(IllegalStateException.class).when(accountsRepository)
	        .findByCustomerId(Mockito.anyInt());
		 
		assertThrows(IllegalStateException.class, () -> {
			accountService.getAccountDetails(786);
		});
	}
}
