package com.mutant.api.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Helper {
    private static Connection connection = null;
    private Statement batchStatement;
    private String jdbcConnectionString;
    private String username;
    private String password;

    public Helper(String jdbcConnectionString, String username, String password) {

        this.jdbcConnectionString = jdbcConnectionString;
        this.username = username;
        this.password = password;
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.mariadb.jdbc.Driver");
        if (connection == null) {
            connection = DriverManager.getConnection(jdbcConnectionString, username, password);
        } else {
            if (connection.isClosed())
                connection = DriverManager.getConnection(jdbcConnectionString, username, password);
        }
        return connection;
    }

    public ResultSet executeQuery(String query) throws  SQLException, ClassNotFoundException {
        if (getConnection() != null) {
            Statement stmt = getConnection().createStatement();
            return stmt.executeQuery(query);
        } else {
            throw new SQLException("No existe conexión activa");
        }
    }

    public void prepareBatch() throws SQLException, ClassNotFoundException {
        batchStatement = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }

    public void addBatchStep(String batchStep) throws SQLException {
        if (batchStatement != null)
            batchStatement.addBatch(batchStep);
    }

    public int[] executeBatch() throws SQLException {
        if (batchStatement != null)
            return batchStatement.executeBatch();
        else return new int[]{};
    }


}
