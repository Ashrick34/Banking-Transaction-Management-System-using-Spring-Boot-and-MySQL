package com.ashrick.banking_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashrick.banking_system.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
	List<Transaction> findByFromAccountIdOrToAccountId(Long fromAccountId, Long toAccountId);
}
