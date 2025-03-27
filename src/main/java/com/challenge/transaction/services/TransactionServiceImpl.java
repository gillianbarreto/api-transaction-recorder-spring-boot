package com.challenge.transaction.services;

import com.challenge.transaction.dto.UpdateTransactionDto;
import com.challenge.transaction.entities.Transaction;
import com.challenge.transaction.exceptions.NotFoundException;
import com.challenge.transaction.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static java.time.LocalDateTime.now;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getTransactions(UUID userId) {
        return transactionRepository.findAllByUserId(userId);
    }

    @Override
    public Transaction getTransactionById(Integer id) {
        return transactionRepository.findById(id).orElseThrow(
                () -> new NotFoundException(this.getNotFoundMessage(id))
        );
    }

    @Override
    public Transaction createTransaction(Transaction transaction) {
        transaction.setIssueDate(now());
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateTransaction(UpdateTransactionDto transaction) {
        Transaction recordToUpdate = this.getTransactionById(transaction.getId());
        recordToUpdate.setAmount(transaction.getAmount());
        recordToUpdate.setDescription(transaction.getDescription());
        return transactionRepository.save(recordToUpdate);
    }

    @Override
    public void deleteTransaction(Integer id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
        } else {
            throw new NotFoundException(this.getNotFoundMessage(id));
        }
    }

    private String getNotFoundMessage(Integer id) {
        return "Transaction " + id + " not found";
    }
}
