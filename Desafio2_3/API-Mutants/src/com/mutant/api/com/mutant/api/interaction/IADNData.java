package com.mutant.api.interaction;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;


public interface IADNData {
	
    HashMap<String, Long> getStats() throws ClassNotFoundException, SQLException;

    void insertADN(String adn, ArrayList<String> states) throws ClassNotFoundException, SQLException;

	
}
