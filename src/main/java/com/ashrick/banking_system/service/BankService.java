package com.ashrick.banking_system.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ashrick.banking_system.entity.Account;
import com.ashrick.banking_system.entity.Transaction;
import com.ashrick.banking_system.repository.AccountRepository;
import com.ashrick.banking_system.repository.TransactionRepository;

@Service
public class BankService {

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public BankService(AccountRepository accountRepository,
                       TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, BigDecimal amount) {

        Transaction transaction = new Transaction();

        try {
            Account sender = accountRepository.findById(fromAccountId)
                    .orElseThrow(() -> new RuntimeException("Sender account not found"));

            Account receiver = accountRepository.findById(toAccountId)
                    .orElseThrow(() -> new RuntimeException("Receiver account not found"));

            if (sender.getBalance().compareTo(amount) < 0) {
                throw new RuntimeException("Insufficient Balance");
            }

            sender.setBalance(sender.getBalance().subtract(amount));
            receiver.setBalance(receiver.getBalance().add(amount));

            accountRepository.save(sender);
            accountRepository.save(receiver);

            transaction.setFromAccountId(fromAccountId);
            transaction.setToAccountId(toAccountId);
            transaction.setAmount(amount);
            transaction.setTransactionType("TRANSFER");
            transaction.setStatus("SUCCESS");

            transactionRepository.save(transaction);

        } catch (Exception e) {

            transaction.setFromAccountId(fromAccountId);
            transaction.setToAccountId(toAccountId);
            transaction.setAmount(amount);
            transaction.setTransactionType("TRANSFER");
            transaction.setStatus("FAILED");

            transactionRepository.save(transaction);

            throw e;
        }
    }
}