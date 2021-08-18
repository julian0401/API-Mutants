package com.mutant.api.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.mutant.api.interaction.DnaAnalyzer;
import com.mutant.api.interaction.IADNData;
import com.mutant.api.model.ADN;
import com.mutant.api.utils.Utils;

public class DnaBusiness {
	
	private DnaAnalyzer adnAnalyzer;
	private IADNData iADNData;

    public DnaBusiness(DnaAnalyzer adnAnalyzer,IADNData iADNData) {
    	this.adnAnalyzer = adnAnalyzer;
    	this.iADNData = iADNData;
    }
	
	public DnaBusiness() {
		
	}

	public boolean isMutant(ADN adn) throws ClassNotFoundException, SQLException {
		boolean result =  false;
		result = adnAnalyzer.isMutant(adn.getADN());
		ArrayList<String> states = new ArrayList<String>();
		if(result) {
			states.add("count_mutant_dna");
		}else {
			states.add("count_human_dna");
		}
		iADNData.insertADN(adn.toString(), states);
		return result;
	}
		
    public JSONObject getStats() throws  JSONException, ClassNotFoundException, SQLException {
        HashMap<String, Long> stats = iADNData.getStats();
        JSONObject result = new JSONObject();
        Iterator it = stats.entrySet().iterator();
        long min = Long.MAX_VALUE;
        while (it.hasNext()) {
            Map.Entry<String, Long> pair = (Map.Entry) it.next();
            result.put(pair.getKey(), pair.getValue());
            //Obtengo el valor minimo para generar el ratio
            if (pair.getValue() < min)
                min = pair.getValue();
        }

        //recorro nuevamente para generar el ratio en el caso de que sea mayor a dos los valores.
        //Si es son dos los valores, se calcula distinto
        if (stats.size() != 2 && min > 0) {
            it = stats.entrySet().iterator();
            String ratio = "";
            while (it.hasNext()) {
                Map.Entry<String, Long> pair = (Map.Entry) it.next();
                //divido el valor por el minimo para obtener cada ratio
                ratio += Utils.roundTwoDecimals((pair.getValue() / min)) + ":";
            }
            result.put("ratio", ratio.substring(0, ratio.length() - 1));
        } else if (stats.size() != 2 && min == 0) {
            result.put("ratio", "undefined");
        } else {
            float first = 0;
            float second = 0;
            it = stats.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Long> pair = (Map.Entry) it.next();
                String key = pair.getKey();
                if (key.equals("count_mutant_dna")) {
                    first = pair.getValue();
                } else if (key.equals("count_human_dna")) {
                    second = pair.getValue();
                }
            }
            if (second != 0)
                result.put("ratio", Utils.roundTwoDecimals(first / second));
            else
                result.put("ratio", "undefined");
        }
        return result;
    }
	
	
	
	
}
