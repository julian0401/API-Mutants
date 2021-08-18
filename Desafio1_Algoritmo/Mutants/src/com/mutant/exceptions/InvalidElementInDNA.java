package com.mutant.exceptions;

@SuppressWarnings("serial")
public class InvalidElementInDNA extends Exception {
    public InvalidElementInDNA() {
        super("El ADN Contiene valores inválidos de bases nitrogenadas");
    }
}
