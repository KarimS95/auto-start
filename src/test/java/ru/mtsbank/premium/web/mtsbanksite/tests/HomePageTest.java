package ru.mtsbank.premium.web.mtsbanksite.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.web.mtsbanksite.pages.HomePage;
import ru.mtsbank.premium.web.mtsbanksite.pages.PremiumPage;

public class HomePageTest extends BaseTest {

    String TEXT = "Премиум";
    String PREMIUM_URL_TEST = "https://site-pred1.mbrd.ru/chastnim-licam/premium/premium-package/";


    @Test
    public void testGetPremiumText() {
        HomePage homePage = new HomePage(driverContainer);
        String text = homePage.getPremiumText();

        Assert.assertEquals(text, TEXT);
    }

    @Test(dependsOnMethods = "testGetPremiumText")
    public void testOpenPremiumLink() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumLink();

        String url = premiumPage.getPremiumPageUrl();

        Assert.assertEquals(url, PREMIUM_URL_TEST);
    }


}
