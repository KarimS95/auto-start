package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumPage;

import java.util.Arrays;
import java.util.List;

public class PremiumPageTest extends BaseTest {

    private static final  String PREMIUM_URL = "https://online.mtsdengi-test.mbrd.ru/premium";
    private static final List<String> LEVEL_PAGE_NAME = Arrays.asList("Уровень", "уровень", "Private", "private");

    @Test(priority = 1)
    public void testCheckLevelPageHeaderName() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();

        boolean found = false;

        for(String check : LEVEL_PAGE_NAME) {
            if(premiumPage.checkLevelPageHeaderName().contains(check)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeaderName")
    public void testCheckPremiumLevelPageIsClickable() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumLevelPage());
    }


    @Test(dependsOnMethods = "testCheckLevelPageHeaderName")
    public void testCheckPremiumCashbackCategoriesListIsClickable() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackCategoriesList());
    }

    @Test(dependsOnMethods = "testCheckPremiumCashbackCategoriesListIsClickable")
    public void testCheckPremiumCashbackPrivilegeIsClickable() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackPrivilege());
    }

    @Test(dependsOnMethods = "testCheckPremiumCashbackPrivilegeIsClickable")
    public void testCheckPrivilegesBlocksIsDisplayed() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPrivilegesBlocksIsDisplayed());
    }

}
