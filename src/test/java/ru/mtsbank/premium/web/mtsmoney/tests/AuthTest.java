package ru.mtsbank.premium.web.mtsmoney.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.web.mtsmoney.constans.Constans;
import ru.mtsbank.premium.web.mtsmoney.pages.HomePage;

public class AuthTest extends BaseTest{


    @Test
    public void testAuth() {
        HomePage homePage = new HomePage(driverContainer);
        String actualURL = homePage.getHomePageURL();
        boolean found = false;

            for(String j : Constans.BASE_URLS_ARRAY.getArrayStringValue()) {
                if(actualURL.contains(j)) {
                    found = true;
                    break;
                }
            }
        Assert.assertTrue(found);
    }

}
