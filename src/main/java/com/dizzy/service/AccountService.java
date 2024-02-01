package com.dizzy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dizzy.model.Accounts;
import com.dizzy.repository.AccountsRepository;

@Service
public class AccountService {

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
	
	
}
