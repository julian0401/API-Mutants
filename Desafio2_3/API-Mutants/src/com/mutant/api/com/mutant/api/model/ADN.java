package com.mutant.api.model;

import com.mutant.api.exceptions.InvalidADNSize;
import com.mutant.api.exceptions.InvalidElementInADN;

public class ADN {
	
	private String[] adn;
    private String dnaElementsRegex = "[ACGT]+";

    public ADN(String[] adn) throws InvalidADNSize, InvalidElementInADN {
        if (adn == null || adn.length == 0 || adn.length != adn[0].length())
            throw new InvalidADNSize();
        for (int i = 1; i < adn.length; i++) {
            if (adn[i].length() != adn[0].length())
                throw new InvalidADNSize();
        }
        for (int i = 0; i < adn.length; i++) {
            if (!adn[i].matches(dnaElementsRegex))
                throw new InvalidElementInADN();
        }
        this.adn = adn;
    }
    
    public String[] getADN() {
        return adn;
    }
    
    public String toString() {
        String result = "";
        for (int i = 0; i < adn.length; i++) {
            result += adn[i] + "-";
        }
        return result.substring(0, result.length() - 1);
    }
	
}
