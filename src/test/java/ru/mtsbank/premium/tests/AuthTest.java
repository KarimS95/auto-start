package ru.mtsbank.premium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.constans.Constans;
import ru.mtsbank.premium.pages.HomePage;

public class AuthTest extends BaseTest{


    @Test
    public void testAuth() {
        HomePage homePage = new HomePage(driverContainer);
        String actualURL = homePage.getHomePageURL();
        boolean found = false;

            for(String j : Constans.BASE_URLS_ARRAY.<String[]>getValue()) {
                if(actualURL.contains(j)) {
                    found = true;
                    break;
                }
            }
        Assert.assertTrue(found);
    }

}
