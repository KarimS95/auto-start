package ru.mtsbank.database.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.database.DbUtils;

import static ru.mtsbank.database.data.TestData.CLIENTS;

public class DatabaseTest {

    @Test(dataProvider = "clients")
    public void testInsertQuery(String clientId) {
        DbUtils dbUtils = new DbUtils();
        int result = dbUtils.insertQuery(clientId);
        boolean isResultTrue = result >= 0;

        Assert.assertTrue(isResultTrue);
    }

    @Test(dataProvider = "clients", dependsOnMethods = "testInsertQuery")
    public void testSelectQuery(String clientId) {
        DbUtils dbUtils = new DbUtils();
        dbUtils.selectQuery(clientId);
    }

    @Test(dataProvider = "clients", dependsOnMethods = "testSelectQuery")
    public void testDeleteQuery(String clientId) {
        DbUtils dbUtils = new DbUtils();
        int result = dbUtils.deleteQuery(clientId);
        boolean isResultTrue = result >= 0;

        Assert.assertTrue(isResultTrue);
    }


    @DataProvider(name = "clients")
    public Object[][] getClients() {
        return new Object[][] {
                {"5515"}
        };
    }
}
