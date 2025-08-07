package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.BasePage;
import ru.mtsbank.pages.HomePage;
import ru.mtsbank.pages.PremiumLevelPage;
import ru.mtsbank.pages.PremiumPage;

public class PremiumLevelTest extends BaseTest{

    private final static String premiumLevelUrl = "https://online.mtsdengi-test.mbrd.ru/premium/level";

    private PremiumLevelPage premiumLevelPage;
    private BasePage basePage;


    @Test
    public void testOpenLevelPage() { //PremiumPage
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();

        premiumPage.openPremiumLevelPage();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(), premiumLevelUrl);
    }

    @Test(dependsOnMethods = "testOpenLevelPage")
    public void testCheckLevelPage() throws InterruptedException {
        premiumLevelPage.checkLevelPage();


    }
}
