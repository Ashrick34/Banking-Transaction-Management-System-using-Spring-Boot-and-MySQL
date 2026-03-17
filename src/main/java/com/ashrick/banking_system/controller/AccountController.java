package com.ashrick.banking_system.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashrick.banking_system.entity.Account;
import com.ashrick.banking_system.entity.Transaction;
import com.ashrick.banking_system.repository.TransactionRepository;
import com.ashrick.banking_system.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@PostMapping("/create")
	public Account createAccount(@RequestParam Long customerId, @RequestParam String accountType) {
		return accountService.createAccount(customerId, accountType);
	}
	
	@PostMapping("/deposit")
	public Account deposit(@RequestParam String accountNumber, @RequestParam BigDecimal amount) {
		return accountService.deposit(accountNumber, amount);
	}
	
	@PostMapping("/withdraw")
	public Account withdraw(@RequestParam String accountNumber, @RequestParam BigDecimal amount) {
		return accountService.withdraw(accountNumber, amount);
	}
}
