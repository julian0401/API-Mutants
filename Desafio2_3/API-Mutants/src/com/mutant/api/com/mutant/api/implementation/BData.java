package com.mutant.api.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.mutant.api.interaction.IADNData;
import com.mutant.api.persistence.Helper;

public class BData implements IADNData {

	Helper dbHelper;

    public BData(Helper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public HashMap<String, Long> getStats() throws  ClassNotFoundException, SQLException {
        HashMap<String, Long> result = new HashMap<String, Long>();
        try {
            ResultSet rs = dbHelper.executeQuery("SELECT name,value FROM STATS");
            while (rs.next()) {
                result.put(rs.getString("name"), rs.getLong("value"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }

    @Override
    public void insertADN(String dna, ArrayList<String> statsnames) throws  ClassNotFoundException, SQLException {
        try {
            ResultSet rs = dbHelper.executeQuery("SELECT count(*) from ADN where adn="+"'"+dna+"'");
            if (rs.next()) {
            	dbHelper.executeQuery("INSERT INTO ADN (adn) VALUES ("+"'"+dna+"'"+")");
                dbHelper.prepareBatch();
                for (int i = 0; i < statsnames.size(); i++)
                    dbHelper.addBatchStep("CALL mutant.incstats('" + statsnames.get(i) + "');");
                	dbHelper.executeBatch();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
	
}
