package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumPage;

import java.util.Arrays;
import java.util.List;

public class PremiumPageTest extends BaseTest {

    private static final  String PREMIUM_URL = "https://online.mtsdengi-test.mbrd.ru/premium";
    private static final List<String> LEVEL_PAGE_NAME = List.of("Уровень", "уровень", "Private", "private");

    @Test(priority = 1)
    public void testCheckLevelPageHeader() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();

        boolean found = false;

        for(String i : LEVEL_PAGE_NAME) {
            if(premiumPage.checkLevelPageHeaderName().contains(i)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeader")
    public void testCheckPremiumLevelPage() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumLevelPage());
    }


    @Test(dependsOnMethods = "testCheckPremiumLevelPage")
    public void testCheckPremiumCashbackCategoriesList() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackCategoriesList());
    }

    @Test(dependsOnMethods = "testCheckPremiumCashbackCategoriesList")
    public void testCheckPremiumCashbackPrivilege() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackPrivilege());
    }

    @Test(dependsOnMethods = "testCheckPremiumCashbackPrivilege")
    public void testCheckPrivilegesBlocks() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPrivilegesBlocks());
    }

}
