package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumLevelPage;
import ru.mtsbank.premium.pages.PremiumPage;

public class PremiumLevelTest extends BaseTest {

    private static final String PREMIUM_LEVEL_URL = "https://online.mtsdengi-test.mbrd.ru/premium/level";
    private static final String EXPECTED_LEVEL_SHEET_HEADER = "уровень";
    private static final String EXPECTED_LEVEL_PAGE_HEADER = "Премиальное обслуживание";


    @Test(priority = 1)
    public void testCheckLevelPageHeaderName() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        PremiumLevelPage premiumLevelPage = premiumPage.openPremiumLevelPage();

        Assert.assertTrue(premiumLevelPage.checkLevelPageHeaderName().contains(EXPECTED_LEVEL_PAGE_HEADER));
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeaderName")
    public void testCheckLevelSheetIsClickable() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertTrue(premiumLevelPage.checkLevelSheetIsClickable());
    }

    @Test(dependsOnMethods = "testCheckLevelSheetIsClickable")
    public void testCheckClickLevelSheet()  {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String actualHeader = premiumLevelPage.checkClickLevelSheet();

        Assert.assertTrue(actualHeader.contains(EXPECTED_LEVEL_SHEET_HEADER));
    }


    @Test(dependsOnMethods = "testCheckClickLevelSheet")
    public void testCheckServicesTermsButtonIsClickable() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertTrue(premiumLevelPage.checkServicesTermsButtonIsClickable());
    }

    @Test(dependsOnMethods = "testCheckServicesTermsButtonIsClickable")
    public void testCheckOpenServicesTermsButton() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertTrue(premiumLevelPage.checkOpenServicesTermsButton());
    }

}
