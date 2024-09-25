package com.sheet.core.database.interfaces;

import java.sql.SQLException;
import java.sql.ResultSet;

public interface Database {
    void getConnection() throws SQLException;
    void closeConnection() throws SQLException;
    ResultSet executeSelect(String req) throws SQLException;
    void initPreparedStatement(String req) throws SQLException;
    int executeUpdate() throws SQLException;
}
