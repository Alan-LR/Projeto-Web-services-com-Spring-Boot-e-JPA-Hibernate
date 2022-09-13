package com.example.demo.services.ServicesExceptions;

public class DatabaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg) {
        super("O usuário possuí pedidos e não pode ser apagado");
    }
}
