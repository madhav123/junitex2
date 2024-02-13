package com.dizzy.mockito.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.RowMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dizzy.model.Accounts;
import com.dizzy.repository.AccountsRepository;
import com.dizzy.service.AccountRecord;
import com.dizzy.service.AccountService;

@SpringBootTest
public class AccountServiceWithMockTest {
	
	@Autowired
	AccountService accountService;
	@MockBean
	AccountsRepository accountsRepository;
	@MockBean
	JdbcTemplate template;

	
	@Test
	public void test1() {
		Accounts mockResponse = new Accounts();
		mockResponse.setBranchAddress("hyd");
		Mockito.when(accountsRepository.findByCustomerId(Mockito.anyInt())).thenReturn(mockResponse);
		Accounts account =accountService.getAccountDetails(0);
		System.out.println("account" + account.getBranchAddress());
		assertEquals("hyd", account.getBranchAddress());
	}
	
	@Test
	public void testAllAccounts() {
		//jdbc call without mock
		//List<Accounts> res =accountService.selectRecords();
		//assertEquals(1, res.size());
		
		
		//jdbc call with mock
		
		List<Accounts> mockResponse = new ArrayList<>();
		mockResponse.add(new Accounts());
		mockResponse.add(new Accounts());
		Mockito.when(template.query(Mockito.anyString(),Mockito.any(AccountRecord.class))).thenReturn(mockResponse);		
		List<Accounts> res =accountService.selectRecords();
		assertEquals(2, res.size());
		
		
	}
	
	
}






 
