package com.dizzy.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.dizzy.model.Accounts;
import com.dizzy.repository.AccountsRepository;

@Service
public class AccountService {
	
	@Autowired
	private  JdbcTemplate template;

	@Autowired
	private AccountsRepository accountsRepository;

	public Accounts getAccountDetails(int id) {
		Accounts accounts = accountsRepository.findByCustomerId(id);
		if (accounts != null) {
			return accounts;
		} else {
			return null;
		}
	}
	
	
	
	public List<Accounts> selectRecords()
    {
         String sql="select a.account_number as accountAumber, a.account_type as accountType from accounts a"; 
         System.out.println("select record form Rommapper");
         AccountRecord dd=new AccountRecord();
         List<Accounts> accounts=template.query(sql, dd);
         System.out.println(accounts.size()+"-------------");
         return accounts;
         }

	
}
