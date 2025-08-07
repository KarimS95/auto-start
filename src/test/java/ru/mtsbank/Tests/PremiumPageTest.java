package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.*;

public class PremiumPageTest extends BaseTest {

    private final static String premiumUrl = "https://online.mtsdengi-test.mbrd.ru/premium";
    private BasePage basePage;


    @BeforeMethod
    public void initObject() {
    }


    @Test(priority = 1)
    public void testPremiumLevelPage() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();

        premiumPage.openPremiumLevelPage();
        basePage.returnToPreviousPage(PremiumPage.class);

        //Assert.assertEquals(driverContainer.get().getCurrentUrl(), premiumUrl);
    }

    @Test(priority = 2)
    public void testOpenPremiumCashbackCategoriesList() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();

        premiumPage.openPremiumCashbackCategoriesList();
        basePage.returnToPreviousPage(PremiumPage.class);
    }

    @Test(priority = 3)
    public void testOpenPremiumCashbackPrivilege() {
       HomePage homePage = new HomePage(driverContainer);
       PremiumPage premiumPage = homePage.openPremiumPage();

       premiumPage.openPremiumCashbackPrivilege();
       basePage.returnToPreviousPage(PremiumPage.class);
    }

}
