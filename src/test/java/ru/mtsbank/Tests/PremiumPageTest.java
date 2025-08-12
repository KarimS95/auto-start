package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.*;

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

        Assert.assertTrue(premiumPage.checkPremiumLevelPageIsClickable());
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeaderName")
    public void testCheckPremiumLevelPageIsDisplayed() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumLevelPageIsDisplayed());
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeaderName")
    public void testCheckPremiumCashbackCategoriesListIsClickable() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackCategoriesListIsClickable());
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeaderName")
    public void testCheckPremiumCashbackCategoriesListIsDisplayed() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackCategoriesListIsDisplayed());
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeaderName")
    public void testCheckPremiumCashbackPrivilegeIsDisplayed() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackPrivilegeIsDisplayed());
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeaderName")
    public void testCheckPremiumCashbackPrivilegeIsClickable() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        Assert.assertTrue(premiumPage.checkPremiumCashbackPrivilegeIsClickable());
    }

}
