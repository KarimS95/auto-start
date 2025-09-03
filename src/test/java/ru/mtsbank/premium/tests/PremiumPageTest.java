package ru.mtsbank.premium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.constans.Constans;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumPage;


public class PremiumPageTest extends BaseTest {


    @Test(priority = 1)
    public void testCheckLevelPageHeader() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        String header = premiumPage.checkLevelPageHeaderName();

        boolean found = false;

        for(String i : Constans.LEVEL_PAGE_NAMES.getArrayStringValue()) {
            if(header.contains(i)) {
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

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testCheckManagerBlock() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String manager = premiumPage.checkManagerBlock();
        boolean isTrue = manager.contains(Constans.MANAGER_VALUE.getStringValue());

        Assert.assertTrue(isTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testGetCallButtonName() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String button = premiumPage.getCallButtonName();
        boolean isTrue = button.equalsIgnoreCase(Constans.MANAGER_CALL_BUTTON.getStringValue());

        Assert.assertTrue(isTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testGetMassageButtonName() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String button = premiumPage.getMassageButtonName();
        boolean isTrue = button.equalsIgnoreCase(Constans.MANAGER_MESSAGE_BUTTON.getStringValue());

        Assert.assertTrue(isTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testCheckCallButton() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        boolean isTrue = premiumPage.checkCallButton();

        Assert.assertTrue(isTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testCheckMessageButton() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        boolean isTrue = premiumPage.checkMessageButton();

        Assert.assertTrue(isTrue);
    }

}
