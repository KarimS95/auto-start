package ru.mtsbank;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DbUtilkaTest {

    @Test (dataProvider = "tests")
    public void testInsertQuery(String clientId) {
        DBUtilka dbUtilka = new DBUtilka();
        dbUtilka.insertQuery(clientId);
    }

    @Test (dataProvider = "tests", dependsOnMethods = "testInsertQuery")
    public void testSelectQuery(String clientId) {
        DBUtilka dbUtilka = new DBUtilka();
        dbUtilka.selectQuery(clientId);
    }

    @Test (dataProvider = "tests", dependsOnMethods = "testSelectQuery")
    public void testDeleteQuery(String clientId) {
        DBUtilka dbUtilka = new DBUtilka();
        dbUtilka.deleteQuery(clientId);
    }


    @DataProvider (name = "tests")
    public Object[][] getClients() {
        return new Object[][] {
                {"12345777"}
        };
    }
}
