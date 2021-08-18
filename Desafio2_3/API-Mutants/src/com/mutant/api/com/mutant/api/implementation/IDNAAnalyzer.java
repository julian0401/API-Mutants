package com.mutant.api.implementation;

import com.mutant.api.interaction.DnaAnalyzer;

public class IDNAAnalyzer implements DnaAnalyzer {
	
	 public boolean isMutant(String[] dna) {
	        int times = 0;
	        String[] mutantSequences = {"AAAA", "TTTT", "CCCC", "GGGG"};
	        for (int m = 0; m < mutantSequences.length; m++) {
	        	String sequence = mutantSequences[m];
	        	
	        for (int i = 0; i < dna.length; i++) {
	            //Busqueda de ocurrencias horizontales
	            if (dna[i].contains(sequence))
	                times++;

	            //Se realiza la diagonal vertical
	            String serieToAnalyze = "";
	            for (int j = 0; j < dna.length - 1; j++) {
	            	serieToAnalyze += dna[j].charAt(i);
	            }

	            //Busqueda de ocurrencias verticales
	            if (serieToAnalyze.contains(sequence))
	                times++;
	        }

	        /*
	         * Diferencia entre la dimension de la matriz y largo de la secuencia 
	         * Sirve para el rango en x  e y para recorrer las diagonales
	         * Utilizado para evitar algunos bucles del for que serian innecesarios
	         */
	        int lengthDifference = dna.length - sequence.length();

	        //Ocurrencias en la diagonal inferior y diagonal central, de arriba para abajo
	        for (int i = lengthDifference; i >= 0; i--) {
	            String serieToAnalyze = "";
	            for (int j = 0; j < dna.length - i; j++) {
	            	serieToAnalyze += dna[i + j].charAt(j);
	            }
	            if (serieToAnalyze.contains(sequence))
	                times++;
	        }
	        
	        //Ocurrencias en la diagonal superior, de arriba para abajo
	        for (int i = 1; i <= lengthDifference; i++) {
	            String serieToAnalyze = "";
	            for (int j = 0; j < dna.length - i; j++) {
	            	serieToAnalyze += dna[j].charAt(i + j);
	            }
	            if (serieToAnalyze.contains(sequence))
	                times++;
	        }

	        //Ocurrencias en la diagonal inferior y diagonal central, de abajo para arriba
	        for (int i = lengthDifference + 1; i < dna.length; i++) {
	            String serieToAnalyze = "";
	            for (int j = 0; j <= i; j++) {
	            	serieToAnalyze += dna[i - j].charAt(j);
	            }
	            if (serieToAnalyze.contains(sequence))
	                times++;
	        }

	        //Ocurrencias en la diagonal superior, de abajo para arriba
	        for (int i = 0; i < lengthDifference; i++) {
	            String serieToAnalyze = "";
	            for (int j = i + 1; j < dna.length; j++) {
	            	serieToAnalyze += dna[dna.length - j + i].charAt(j);
	            }
	            if (serieToAnalyze.contains(sequence))
	                times++;
	        }
	      }
	      if(times>0) {
	    	  return true;
	      }else {
	    	  return false;
	      }
	    }

}
