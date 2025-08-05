package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.PremiumLevelPage;
import ru.mtsbank.pages.PremiumPage;

public class PremiumLevelPageTest extends BaseTest{

    private final static String premiumLevelUrl = "https://online.mtsdengi-test.mbrd.ru/premium/level";
    private PremiumPage premiumPage;
    private PremiumLevelPage premiumLevelPage;

    @BeforeMethod
    public void getInit() {
        premiumPage = new PremiumPage(driverContainer);
        premiumLevelPage = new PremiumLevelPage(driverContainer);
    }

    @Test
    public void testOpenLevelPage() {
        premiumPage.openPremiumPage();
        premiumLevelPage.openLevelPage();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(), premiumLevelUrl);
    }

    @Test(dependsOnMethods = "testOpenLevelPage")
    public void testCheckLevelPage() throws InterruptedException {
        premiumLevelPage.checkLevelPage();


    }
}
