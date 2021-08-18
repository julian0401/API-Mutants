package com.mutant.api.exceptions;

@SuppressWarnings("serial")
public class InvalidElementInADN extends Exception {
    public InvalidElementInADN() {
        super("El ADN Contiene valores inválidos");
    }
}
