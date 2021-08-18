package com.mutant.exceptions;

public class InvalidDNASize extends Exception {
    public InvalidDNASize() {
        super("El tamaño del adn es inválido. Debe ser de NxN");
    }
}
