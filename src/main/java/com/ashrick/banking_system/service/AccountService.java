package com.ashrick.banking_system.service;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashrick.banking_system.entity.Account;
import com.ashrick.banking_system.entity.Customer;
import com.ashrick.banking_system.entity.Transaction;
import com.ashrick.banking_system.repository.AccountRepository;
import com.ashrick.banking_system.repository.CustomerRepository;
import com.ashrick.banking_system.repository.TransactionRepository;

@Service
public class AccountService {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public AccountService(CustomerRepository customerRepository,
                          AccountRepository accountRepository,
                          TransactionRepository transactionRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account createAccount(Long customerId, String accountType) {

        Optional<Customer> customerOptional = customerRepository.findById(customerId);

        if (!customerOptional.isPresent()) {
            throw new RuntimeException("Customer not found");
        }

        Customer customer = customerOptional.get();

        Account account = new Account();
        account.setAccountType(accountType);
        account.setBalance(BigDecimal.ZERO);
        account.setAccountNumber(generateAccountNumber());
        account.setCustomer(customer);

        return accountRepository.save(account);
    }

    private String generateAccountNumber() {
        return UUID.randomUUID().toString().substring(0, 10);
    }

    
    @Transactional
    public Account deposit(String accountNumber, BigDecimal amount) {

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance().add(amount));

        Transaction transaction = new Transaction();
        transaction.setToAccountId(account.getId());
        transaction.setAmount(amount);
        transaction.setTransactionType("DEPOSIT");
        transaction.setStatus("SUCCESS");

        transactionRepository.save(transaction);

        return accountRepository.save(account);
    }

    
    @Transactional
    public Account withdraw(String accountNumber, BigDecimal amount) {

        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("Insufficient Balance");
        }

        account.setBalance(account.getBalance().subtract(amount));

        Transaction transaction = new Transaction();
        transaction.setFromAccountId(account.getId());
        transaction.setAmount(amount);
        transaction.setTransactionType("WITHDRAW");
        transaction.setStatus("SUCCESS");

        transactionRepository.save(transaction);

        return accountRepository.save(account);
    }
}