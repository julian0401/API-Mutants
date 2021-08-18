package com.mutant.api.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mutant.api.implementation.BData;
import com.mutant.api.implementation.IDNAAnalyzer;
import com.mutant.api.interaction.IADNData;
import com.mutant.api.persistence.Helper;
import com.mutant.api.services.DnaBusiness;

public class Controller {
    String connectionString = "";
    String userName = "";
    String password = "";

    Helper helper;
    IDNAAnalyzer adnAnalyzer;
    IADNData idnaData;
    DnaBusiness bussiness;

    void readConfig() throws IOException {
        InputStream inputStream = null;
        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                System.out.println("[INITIALIZACION] File not found: " + "property file '" + propFileName + "' not found in the classpath");
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            connectionString = prop.getProperty("connectionString");
            userName = prop.getProperty("userName");
            password = prop.getProperty("password");
        } catch (Exception e) {
            System.out.println("[INITIALIZACION] Exception: " + e);
            throw e;
        } finally {
            if (inputStream != null)
                inputStream.close();
        }
    }

    void InitializeDependencies() {
        /* Classes Construction  (Must change for IOC Container)*/
    	helper = new Helper(connectionString,
                userName,
                password);
        idnaData = new BData(helper);
        adnAnalyzer = new IDNAAnalyzer();
        bussiness = new DnaBusiness(adnAnalyzer,idnaData);
        /* End of Classes Construction */
    }
}
