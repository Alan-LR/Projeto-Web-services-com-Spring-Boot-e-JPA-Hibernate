package com.example.demo.services.ServicesExceptions;

public class ResourceNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Não encontramos o Id. Id" + id);
    }

}
