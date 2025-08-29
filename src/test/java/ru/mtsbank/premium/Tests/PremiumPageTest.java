package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumPage;

import java.util.Arrays;
import java.util.List;

public class PremiumPageTest extends BaseTest {

    private final String PREMIUM_URL = "https://online.mtsdengi-test.mbrd.ru/premium";
    private final List<String> LEVEL_PAGE_NAME = List.of("Уровень", "уровень", "Private", "private");
    private final String MANAGER_BLOCK = "менеджер";
    private final String CALL_BUTTON = "позвонить";
    private final String MESSAGE_BUTTON = "написать";


    @Test(priority = 1)
    public void testCheckLevelPageHeader() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        String header = premiumPage.checkLevelPageHeaderName();

        boolean found = false;

        for(String i : LEVEL_PAGE_NAME) {
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
        boolean isTrue = manager.contains(MANAGER_BLOCK);

        Assert.assertTrue(isTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testGetCallButtonName() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String button = premiumPage.getCallButtonName();
        boolean isTrue = button.equalsIgnoreCase(CALL_BUTTON);

        Assert.assertTrue(isTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLevelPageHeader")
    public void testGetMassageButtonName() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);
        String button = premiumPage.getMassageButtonName();
        boolean isTrue = button.equalsIgnoreCase(MESSAGE_BUTTON);

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
