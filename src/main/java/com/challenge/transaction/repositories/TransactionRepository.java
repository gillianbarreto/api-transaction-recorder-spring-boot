package com.challenge.transaction.repositories;

import com.challenge.transaction.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query("SELECT m FROM Transaction m WHERE m.userId = :userId ORDER BY m.issueDate DESC")
    List<Transaction> findAllByUserId(@Param("userId")UUID userId);
}
