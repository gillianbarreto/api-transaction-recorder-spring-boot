# API - Simulador de Registro de Transacciones

API que simula el registro y actualización de transacciones, de acuerdo a los siguientes endpoints

1) **GET** /api/transactions: Devuelve el historial de transacciones realizadas por un usuario,
2) **POST** /api/transactions: Añade una transacción.
3) **PUT** /api/transactions: Modifica el monto y descripción de una transacción.
4) **DELETE** /api/transactions/{id}: Elimina una transacción.

## Especificaciones

El desarrollo está hecho en Spring Boot y se conecta una base de datos PostgreSQL para guardar la información de las transacciones realizadas.

# Documentación - Swagger

Local: 
http://localhost:8080/swagger-ui/index.html#/