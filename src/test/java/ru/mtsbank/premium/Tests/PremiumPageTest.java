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
            if(premiumPage.checkLevelPageHeaderName().equals(i)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testCheckPremiumLevelPage() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumLevelPage());
    }


    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testCheckPremiumCashbackCategoriesList() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackCategoriesList());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testCheckPremiumCashbackPrivilege() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackPrivilege());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testCheckPrivilegesBlocks() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPrivilegesBlocks());
    }

}
