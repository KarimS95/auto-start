package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.BasePage;
import ru.mtsbank.pages.HomePage;
import ru.mtsbank.pages.PremiumLevelPage;
import ru.mtsbank.pages.PremiumPage;

public class PremiumLevelTest extends BaseTest {

    private static final String premiumLevelUrl = "https://online.mtsdengi-test.mbrd.ru/premium/level";
    private static final String expectedHeader = "уровень";


    @Test
    public void testCheckLevelPage()  {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        PremiumLevelPage premiumLevelPage = premiumPage.openPremiumLevelPage();
        String actualHeader = premiumLevelPage.checkLevelSheet();
        

        Assert.assertTrue(actualHeader.contains(expectedHeader));

    }
}
