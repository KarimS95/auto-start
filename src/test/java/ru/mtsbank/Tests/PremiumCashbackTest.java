package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.HomePage;
import ru.mtsbank.pages.PremiumCashbackPage;
import ru.mtsbank.pages.PremiumPage;

import java.util.Arrays;
import java.util.List;

public class PremiumCashbackTest extends BaseTest {

    private static final List<String> getCategoristListHeader = Arrays.asList("Кешбэк", "кешбэк");
    private static final int checkboxesCount = 5;

    private PremiumPage premiumPage;
    private PremiumCashbackPage premiumCashbackPage;

    @Test(priority = 1)
    public void testCheckCategoriesList() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        PremiumCashbackPage premiumCashbackPage = premiumPage.openPremiumCashbackPrivilege();

        Assert.assertTrue(premiumCashbackPage.categoriesListIsDisplaying());
    }

    @Test(dependsOnMethods = "testCheckCategoriesList")
    public void testPremiumCashbackCategoriesList() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        premiumCashbackPage.openCategoriesList();

        boolean isHeaderTrue = false;
        for(String iterator : getCategoristListHeader) {
            if(premiumCashbackPage.getCategoriesHeader().contains(iterator)) {
                isHeaderTrue = true;
            }
        }
        Assert.assertTrue(isHeaderTrue);

        boolean isCheckboxesTrue = (premiumCashbackPage.checkboxesCount() >= checkboxesCount);
        Assert.assertTrue(isCheckboxesTrue);

    }

    @Test(dependsOnMethods = "testPremiumCashbackCategoriesList")
    public void testSelectPremiumCashbackCategories() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        premiumCashbackPage.selectCashbackCategoriesCheckboxes();
        premiumCashbackPage.clickOnCategoriesSelectButton();
        premiumCashbackPage.clickOnSuccessfullButton();

        Assert.assertTrue(premiumCashbackPage.selectedCategoriesDisplaying());

    }

    @Test(dependsOnMethods = "testSelectPremiumCashbackCategories")
    public void testCheckLevelPageLinkIsDisplayed() throws InterruptedException { //изменить метод
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkLevelPageLinkIsDisplayed());
    }

    @Test(dependsOnMethods = "testCheckLevelPageLinkIsDisplayed")
    public void testCheckLevelPageLinkIsClickable() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkLevelPageLinkIsClickable());
    }

    @Test(dependsOnMethods = "testCheckLevelPageLinkIsClickable")
    public void testCheckFirstLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkFirstLink());
    }

    @Test(dependsOnMethods = "testCheckFirstLink")
    public void testCheckSecondLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkSecondLink());
    }

    @Test(dependsOnMethods = "testCheckSecondLink")
    public void testCheckThirdLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkThirdLink());
    }


}
