package com.ashrick.banking_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashrick.banking_system.entity.Transaction;
import com.ashrick.banking_system.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<Transaction> getAllTransaction(){
		return transactionRepository.findAll();
	}
	
	public List<Transaction> getTransactionsByAccountId(Long accountId){
		return transactionRepository.findByFromAccountIdOrToAccountId(accountId, accountId);
	}
}
