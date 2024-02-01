package com.dizzy.mockito.integration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dizzy.model.Accounts;
import com.dizzy.service.AccountService;

@SpringBootTest
public class AccountServiceTest {
	
	@Autowired
	AccountService accountService;
    
	@Test
	public void test1() {
		Accounts account =accountService.getAccountDetails(1);
		System.out.println("account" + account.getBranchAddress());
		assertNotNull(account);
	}
}
