package com.challenge.transaction.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class UpdateTransactionDto {
    @NotNull(message = "El ID no puede ser nulo")
    private Integer id;

    @NotNull(message = "El monto no puede ser nulo")
    @Min(value = 1, message = "El monto debe ser mayor que 0")
    private Integer amount;

    @NotBlank(message = "La descripción no puede estar vacía")
    @Size(min = 3, message = "La descripción debe tener al menos 3 caracteres")
    private String description;
}