package com.ashrick.banking_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashrick.banking_system.dto.TransferRequest;
import com.ashrick.banking_system.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {
	
	@Autowired
	private BankService bankService;
	
	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestBody TransferRequest request){
		bankService.transferMoney(
		request.getFromAccountId(),
        request.getToAccountId(),
        request.getAmount());

		return ResponseEntity.ok("Transfer Successful");
	}
	
}
