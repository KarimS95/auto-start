package ru.mtsbank.premium.web.mtsbanksite.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.web.mtsbanksite.constans.Constants;
import ru.mtsbank.premium.web.mtsbanksite.pages.HomePage;
import ru.mtsbank.premium.web.mtsbanksite.pages.PremiumPage;

public class HomePageTest extends BaseTest {


    @Test
    public void testGetPremiumTabText() {
        HomePage homePage = new HomePage(driverContainer);
        String text = homePage.getPremiumTabText();

        Assert.assertEquals(text, Constants.PREMIUM_TAB_TEXT.getStringValue());
    }

    @Test(dependsOnMethods = "testGetPremiumTabText")
    public void testOpenPremiumLink() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumLink();

        String url = premiumPage.getPremiumPageUrl();

        Assert.assertEquals(url, Constants.PREMIUM_TEST_URL.getStringValue());
    }


}
