package com.challenge.transaction.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="transaction")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(unique = true, updatable = false)
    private Integer id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(nullable = false)
    private Integer amount;

    @Column(length = 255)
    private String description;

    @Column(name = "issue_date")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDateTime issueDate;
}