package com.dev.aerolinea.exception;

//para cuando no se encuentra un vuelo
public class VueloNotFoundException extends RuntimeException {
   
    public VueloNotFoundException(String message) {
        super(message);
    }
}
