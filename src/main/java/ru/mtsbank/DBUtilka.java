package ru.mtsbank;

import java.sql.*;

public class DBUtilka {

    private Connection getConnection() {
        String url = "jdbc:postgresql://prem-pgr-d01t.mbrd.ru:5432/premium_cashback_category_db";
        String username = "premium_cashback_category_adm";
        String password = "AqbkUBdJ7bg1mrdp1kPS";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int insertQuery(String clientId) {
        int result = 0;
        String sql = String.format(
                """
                 INSERT INTO customer_cash (id,cash_id,client_id,begin_dt,end_dt,enabled,created,updated,cancel_reason,canceled)
                 VALUES ('-2132324',595, %s,'2025-01-01','2025-01-31',true,'2025-01-10 00:00:00.000',null,null,null);
                """, Long.parseLong(clientId));

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(sql);
            System.out.println("Создано записей: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void selectQuery(String clientId) {
        ResultSet resultSet;
        int rowCount;
        String rowIntoString = "";

        String sql = String.format(
                """
                SELECT *
                FROM customer_cash
                WHERE client_id = %s
                """
        , Long.parseLong(clientId));

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            rowCount = resultSet.getMetaData().getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i < rowCount; i++) {
                    rowIntoString += resultSet.getMetaData().getColumnName(i) + ": " + resultSet.getString(i) + "\n";
                }
                System.out.println(rowIntoString);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int deleteQuery(String clientId) {
        int result = 0;
        String sql = String.format(
                """
                DELETE
                FROM customer_cash
                WHERE client_id = %s
                """
        ,Long.parseLong(clientId));

        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(sql);
            System.out.println("Удалено записей: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
