package com.challenge.transaction.controllers;

import com.challenge.transaction.dto.CreateTransactionDto;
import com.challenge.transaction.dto.UpdateTransactionDto;
import com.challenge.transaction.entities.Transaction;
import com.challenge.transaction.exceptions.BadRequestException;
import com.challenge.transaction.services.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.UUID;
import jakarta.validation.Valid;

@RestController
@Tag(name = "Transacciones", description="Controlador de transacciones")
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    @Operation(
            summary = "Listado de transacciones",
            description = "Obtener una lista de transacciones realizadas por un usuario"
    )
    public List<Transaction> getTransactions() {
        UUID userId = UUID.fromString("4b34eea4-ebbf-48b3-a9c1-98998dab46df"); // TODO: debería extraerse del token
        return transactionService.getTransactions(userId);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Consultar una transacción",
            description = "Consultar una transacción por su id"
    )
    public Transaction getTransactionById(@PathVariable("id") Integer id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping
    @Operation(
            summary = "Registrar una transacción",
            description = "Registrar una transacción realizada por el usuario"
    )
    public Transaction createTransaction(@Valid @RequestBody CreateTransactionDto transactionDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException("Error en los datos del request");
        }
        Transaction transaction = new Transaction();
        transaction.setUserId(UUID.fromString("4b34eea4-ebbf-48b3-a9c1-98998dab46df")); // TODO: debería extraerse del token
        transaction.setDescription(transactionDto.getDescription());
        transaction.setAmount(transaction.getAmount());
        return transactionService.createTransaction(transaction);
    }

    @PutMapping
    @Operation(
            summary = "Actualizar una transacción",
            description = "Actualizar una transacción por su id"
    )
    public Transaction updateTransaction(@Valid @RequestBody UpdateTransactionDto transaction, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestException("Error en los datos del request");
        }

        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar una transacción",
            description = "Eliminar una transacción por su id"
    )
    public void deleteTransaction(@PathVariable("id") Integer id) {

        transactionService.deleteTransaction(id);
    }
}
