package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumCashbackPage;
import ru.mtsbank.premium.pages.PremiumPage;

import java.util.Arrays;
import java.util.List;

public class PremiumCashbackTest extends BaseTest {

    private static final List<String> CATEGORIES_LIST_HEADER = Arrays.asList("Кешбэк", "кешбэк");
    private static final int CHECKBOXES_COUNT = 5;
    private static final List<String> EXPECTED_LIST = Arrays.asList("Премиальное обслуживание", "https://online.mtsdengi-test.mbrd.ru/premium","https://online.mtsdengi-dev.mbrd.ru/premium");



    @Test(priority = 1)
    public void testOpenPremiumCashbackCategoriesList() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        PremiumCashbackPage premiumCashbackPage = premiumPage.openPremiumCashbackPrivilege();

        premiumCashbackPage.openCategoriesList();

        boolean isHeaderTrue = false;
        for(String iterator : CATEGORIES_LIST_HEADER) {
            if(premiumCashbackPage.getCategoriesListHeader().contains(iterator)) {
                isHeaderTrue = true;
                break;
            }
        }

        Assert.assertTrue(isHeaderTrue);

        boolean isCheckboxesTrue = (premiumCashbackPage.getCheckboxesCount() >= CHECKBOXES_COUNT);
        Assert.assertTrue(isCheckboxesTrue);

    }

    @Test(dependsOnMethods = "testOpenPremiumCashbackCategoriesList")
    public void testSelectPremiumCashbackCategories() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        premiumCashbackPage.selectCashbackCategoriesCheckboxes();
        premiumCashbackPage.clickOnCategoriesSelectButton();
        premiumCashbackPage.clickOnSuccessfullButton();

        Assert.assertTrue(premiumCashbackPage.selectedCategoriesDisplayed());

    }

    @Test(dependsOnMethods = "testSelectPremiumCashbackCategories")
    public void testCheckOpenLevelPageLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        boolean isTrue = false;
        for(String iterator : EXPECTED_LIST) {
            if(premiumCashbackPage.checkOpenLevelPageLink().contains(iterator)) {
                isTrue = true;
                break;
            }
        }

        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testCheckOpenLevelPageLink")
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
