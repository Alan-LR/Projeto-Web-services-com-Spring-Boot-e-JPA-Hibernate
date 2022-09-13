package com.example.demo.services.ServicesExceptions;

public class DatabaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DatabaseException(String msg) {
        super("Não podemos deletar o usuário, o mesmo possuí pedidos");
    }
}
