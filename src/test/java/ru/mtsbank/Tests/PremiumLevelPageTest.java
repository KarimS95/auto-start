package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.PremiumLevelPage;
import ru.mtsbank.pages.PremiumPage;

public class PremiumLevelPageTest extends BaseTest{

    private final static String premiumLevelUrl = "https://online.mtsdengi-test.mbrd.ru/premium/level";

    private PremiumLevelPage premiumLevelPage;
    private PremiumPage premiumPage;

    @BeforeMethod
    public void getInit() {
        premiumLevelPage = new PremiumLevelPage(driverContainer);
        premiumPage = new PremiumPage(driverContainer);
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
