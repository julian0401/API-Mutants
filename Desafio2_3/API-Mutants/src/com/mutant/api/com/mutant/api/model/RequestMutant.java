package com.mutant.api.model;

public class RequestMutant {
	String[] dna;

    public RequestMutant() {
    }

    public RequestMutant(String[] dna) {
        this.dna = dna;
    }

    public String[] getDna() {
        return this.dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }
	
}
