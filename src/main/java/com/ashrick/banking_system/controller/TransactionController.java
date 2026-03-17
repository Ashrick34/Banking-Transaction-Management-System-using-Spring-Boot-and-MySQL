package com.ashrick.banking_system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ashrick.banking_system.entity.Transaction;
import com.ashrick.banking_system.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping
	public List<Transaction> getAllTransaction(){
		return transactionService.getAllTransaction();
	}
	
	@GetMapping("/account/{accountId}")
	public List<Transaction> getByAccount(@PathVariable Long accountId) {
	    return transactionService.getTransactionsByAccountId(accountId);
	}
}
