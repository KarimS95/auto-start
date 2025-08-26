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
    private String EXPECTED_TERMS_HEADER = "Условия обслуживания";


    @Test(priority = 1)
    public void testCheckLevelPageHeader() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        PremiumLevelPage premiumLevelPage = premiumPage.openPremiumLevelPage();

        Assert.assertTrue(premiumLevelPage.getLevelPageHeader().contains(EXPECTED_LEVEL_PAGE_HEADER));
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeader")
    public void testOpenLevelSheet()  {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertTrue(premiumLevelPage.openLevelSheet().contains(EXPECTED_LEVEL_SHEET_HEADER));

        premiumLevelPage.closeLevelSheet();
    }

    @Test(dependsOnMethods = "testOpenLevelSheet")
    public void testOpenServicesTermsButton() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertEquals(premiumLevelPage.openServicesTermsButton(),EXPECTED_TERMS_HEADER);

        premiumLevelPage.returnBack();
    }

    @Test(dependsOnMethods = "testOpenServicesTermsButton")
    public void testOpenFirstI() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        premiumLevelPage.openFirstI();
    }

    @Test
    public void testCloseFirstI() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        premiumLevelPage.closeFirstI();
    }

    @Test
    public void testOpenSecond() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        premiumLevelPage.openSecondI();
    }

    @Test
    public void testCloseSecondI() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        premiumLevelPage.closeSecondI();
    }

    @Test
    public void testOpenThirdI() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        premiumLevelPage.openThirdI();
    }

    @Test
    public void testCloseThirdI() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        premiumLevelPage.closeThirdI();
    }



}
