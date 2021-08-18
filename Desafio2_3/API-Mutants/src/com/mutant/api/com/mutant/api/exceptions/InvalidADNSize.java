package com.mutant.api.exceptions;

@SuppressWarnings("serial")
public class InvalidADNSize extends Exception {
    public InvalidADNSize() {
        super("El tamaño del ADN es invalido");
    }
}
