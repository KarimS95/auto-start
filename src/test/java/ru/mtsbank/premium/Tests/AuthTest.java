package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;

public class AuthTest extends BaseTest{

    private static final String[] URL = {"https://online.mtsdengi-dev.mbrd.ru/","https://online.mtsdengi-test.mbrd.ru/"};

    @Test
    public void testAuth() {
        HomePage homePage = new HomePage(driverContainer);
        String actualURL = homePage.getHomePageURL();
        boolean found = false;

            for(String j : URL) {
                if(actualURL.equals(j)) {
                    found = true;
                    break;
                }
            }

        Assert.assertTrue(found);
    }

}
