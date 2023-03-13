package org.example.ConnectionManager;

import org.example.PropertiesUtil.PropertiesUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private static final String PASSWORD_KEY = "password";
    private static final String USERNAME_KEY = "username";
    private static final String URL_KEY = "url";
    private static Connection conn = null;

    private ConnectionManager() {

    }

    //    private static void loadDriver(){
//        try {
//            Class.forName("java.sql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static Connection openConnection() throws SQLException {
        try {
            Class.forName("java.sql.Driver");
            conn = DriverManager.getConnection(
                    PropertiesUtil.get(URL_KEY),
                    PropertiesUtil.get(USERNAME_KEY),
                    PropertiesUtil.get(PASSWORD_KEY)

            );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return conn;

    }
//    public void close(){
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        conn = null;
//    }
}
