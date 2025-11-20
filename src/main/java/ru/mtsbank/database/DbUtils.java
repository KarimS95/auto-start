package ru.mtsbank.database;

import org.postgresql.util.PSQLException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DbUtils {

    private Connection getConnection() {
        Connection connection = null;

//        Properties properties = null;
//        FileInputStream fis = null;
//
//        String url = null;
//        String username = null;
//        String password = null;
//
//        try {
//            fis = new FileInputStream("configurations/database.config");
//            properties.load(fis);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        url = properties.getProperty("premium_cashback_category_db");
//        username = properties.getProperty("premium_cashback_category_db_username");
//        password = properties.getProperty("premium_cashback_category_db_password");

        String url = "";
        String username = "";
        String password = "";

        try {
            connection = DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int insertQuery(String clientId) {
        int result = 0;
        String sql = String.format("""
                INSERT INTO customer_cash (id,cash_id,client_id,begin_dt,end_dt,enabled,created,updated,cancel_reason,canceled)
                VALUES (-9993330001115,1663,%s,'2025-09-01','2025-09-30',true,null,null,null,null);
                """, Long.parseLong(clientId));

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(sql);
            System.out.println("Добавлено значений: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void selectQuery(String clientId) {
        ResultSet resultSet = null;
        int columnCount = 0;
        String rowAsString = "";

        String sql = String.format("""
                SELECT *
                FROM customer_cash
                WHERE client_id = %s
                """, Long.parseLong(clientId));

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            columnCount = resultSet.getMetaData().getColumnCount();

            if (resultSet.next()) {
                for (int i = 1; i < columnCount; i++) {
                    rowAsString += resultSet.getMetaData().getColumnName(i) + ": " + resultSet.getString(i) + ",\n";
                }
                System.out.println("Результат получения данных:\n" + rowAsString);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int deleteQuery(String clientId) {
        int result = 0;
        String sql = String.format("""
                DELETE
                FROM customer_cash
                WHERE client_id = %s
                """, Long.parseLong(clientId));

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(sql);
            System.out.println("Удалено значений: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}