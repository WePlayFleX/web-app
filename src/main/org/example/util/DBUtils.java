package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

    public static final String DB_URL = "jdbc:mysql://localhost:3308/crazy_app_db";
    public static final String DB_USER = "root";
    public static final String DB_USER_PWD = "";


    public static Connection getConnection(){
        Connection conn = null;
        try {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_USER_PWD);
            if (!conn.isClosed()) {
                System.out.println("Connections is open");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  conn;
    }


    public static void closeConnection(Connection conn){
        try {
            if (conn != null){
                conn.close();
                System.out.println("Connections is closed");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
