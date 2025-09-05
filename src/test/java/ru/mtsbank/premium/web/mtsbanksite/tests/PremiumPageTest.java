package ru.mtsbank.premium.web.mtsbanksite.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.web.mtsbanksite.constans.Constants;
import ru.mtsbank.premium.web.mtsbanksite.pages.HomePage;
import ru.mtsbank.premium.web.mtsbanksite.pages.PremiumPage;

public class PremiumPageTest extends BaseTest {


    @Test
    public void testGetPremiumPageGeneralHeader() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumLink();
        String header = premiumPage.getPremiumPageGeneralHeader();

        Assert.assertEquals(header, Constants.PREMIUM_GENERAL_HEADER.getStringValue());
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testGetAfterHeaderText() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String text = premiumPage.getAfterHeaderText();

        Assert.assertEquals(text, Constants.PREMIUM_AFTER_HEADER_TEXT.getStringValue());
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testGetAfterHeaderFirstButtonText() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String text = premiumPage.getAfterHeaderFirstButtonText();

        Assert.assertEquals(text, Constants.PREMIUM_AFTER_HEADER_FIRST_BUTTON_TEXT.getStringValue());
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testGetAfterHeaderSecondButtonText() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String text = premiumPage.getAfterHeaderSecondButtonText();

        Assert.assertEquals(text, Constants.PREMIUM_AFTER_HEADER_SECOND_BUTTON_TEXT.getStringValue());
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testCheckFirstButton() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        boolean isTrue = premiumPage.checkAfterHeaderFirstButton();

        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testCheckSecondButton() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        boolean isTrue = premiumPage.checkAfterHeaderSecondButton();

        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testGetAboutServicesTabText() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String text = premiumPage.getAboutServicesTabText();

        Assert.assertEquals(text, Constants.PREMIUM_ABOUT_SERVICES_TAB_TEXT.getStringValue());
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testGetServicesAndTariffsTabText() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String text = premiumPage.getServicesAndTariffsTabText();

        Assert.assertEquals(text, Constants.PREMIUM_SERVICES_AND_TARIFFS_TAB.getStringValue());
    }

    @Test(dependsOnMethods = "testGetPremiumPageGeneralHeader", groups = "parallel")
    public void testGetPremiumServiceHeader() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String header = premiumPage.getPremiumServiceHeader();

        Assert.assertEquals(header, Constants.PREMIUM_SERVICE_HEADER.getStringValue());
    }

    @Test(dependsOnGroups = "parallel")
    public void testGetNextButtonText() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        premiumPage.clickFirstButton();
        String text = premiumPage.getNextButtonText();

        Assert.assertEquals(text, Constants.PREMIUM_NEXT_BUTTON.getStringValue());
    }

    @Test(dependsOnMethods = "testGetNextButtonText")
    public void testCheckNextButtonDisable() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        boolean isTrue = premiumPage.checkNextButtonDisable();

        Assert.assertTrue(isTrue);
    }



}
