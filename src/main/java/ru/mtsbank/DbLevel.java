package ru.mtsbank;

import java.sql.*;

public class DbLevel {

    private Connection getConnection() {
        Connection connection = null;

        String url = "";
        String username = "";
        String password = "";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public int updateLevel(String clientId, String level) {
        int result = 0;
        String sql = String.format(
                """
                UPDATE client
                SET level = %s
                WHERE rbo_id = %s
                """
        , Long.parseLong(level), Long.parseLong(clientId));

        try(Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            result = statement.executeUpdate(sql);
            System.out.println("Изменено записей: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public String selectLevel(String clientId, String inerationsCount) {
        ResultSet resultSet;
        String rowAsString = "";

        String sql = String.format(
                """
                SELECT rbo_id, level
                FROM client
                WHERE rbo_id = %s
                """
        , Long.parseLong(clientId));


        try(Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println("Полученные данные:");
                for (int i = 1; i < Integer.parseInt(inerationsCount); i++) {
                    rowAsString = resultSet.getMetaData().getColumnName(i) + ": " + resultSet.getString(i);
                    System.out.println(rowAsString);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  rowAsString;
    }
}