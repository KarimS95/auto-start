package ru.mtsbank;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DbKTest {

    @Test(dataProvider = "data")
    public void testUpdateLevel(String clientId, String level) {
        DbLevel dbLevel = new DbLevel();

        dbLevel.updateLevel(clientId, String.valueOf(level));
        dbLevel.selectLevel(clientId, "3");
    }

//    @Test(dependsOnMethods = "testUpdateLevel")
//    public void testSelectLevel() {
//        DbLevel dbLevel = new DbLevel();
//        dbLevel.selectLevel("91400715276", "3");
//    }


    @DataProvider(name = "data")
    public Object[][] getData() {
        return new Object[][] {
                {"91400715276", "1"},
                {"91400715276", "2"},
                {"91400715276", "3"}
        };
    }
}