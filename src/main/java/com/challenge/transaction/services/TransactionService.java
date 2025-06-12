package com.challenge.transaction.services;

import com.challenge.transaction.dto.UpdateTransactionDto;
import com.challenge.transaction.entities.Transaction;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    public List<Transaction> getTransactions (UUID userId);
    public Transaction getTransactionById (Integer id);
    public Transaction createTransaction (Transaction transaction);
    public Transaction updateTransaction (UpdateTransactionDto transaction);
    public void deleteTransaction (Integer id);
}
