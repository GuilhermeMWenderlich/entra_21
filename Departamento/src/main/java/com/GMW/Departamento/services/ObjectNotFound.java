package com.GMW.Departamento.services;

public class ObjectNotFound extends RuntimeException {

    public ObjectNotFound(String message) {
        super(message);
    }

    public ObjectNotFound(String message, Throwable cause) {
        super(message, cause);
    }


    
}
