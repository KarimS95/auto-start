package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumCashbackPage;
import ru.mtsbank.premium.pages.PremiumPage;

import java.util.Arrays;
import java.util.List;

public class PremiumCashbackTest extends BaseTest {

    private static final List<String> CASHBACK_HEADER = Arrays.asList("Кешбэк", "кешбэк");
    private static final int CHECKBOXES_COUNT = 5;
    private static final List<String> URLS_LIST = Arrays.asList("https://online.mtsdengi-test.mbrd.ru/premium","https://online.mtsdengi-dev.mbrd.ru/premium");
    private final String PREMIUM_LEVEL_PAGE_HEADER = "Премиальное обслуживание";
    private final List<String> CASHBACK_URL = Arrays.asList("https://online.mtsdengi-test.mbrd.ru/premium/cashback","https://online.mtsdengi-dev.mbrd.ru/premium/cashback");



    @Test(priority = 1)
    public void testOpenPremiumCashbackCategoriesList() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        PremiumCashbackPage premiumCashbackPage = premiumPage.openPremiumCashbackPrivilege();

        premiumCashbackPage.openCategoriesList();

        boolean isHeaderTrue = false;
        for(String iterator : CASHBACK_HEADER) {
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
        premiumCashbackPage.clickOnSuccessfulButton();

        Assert.assertTrue(premiumCashbackPage.checkSelectedCategories());

    }

    @Test(dependsOnMethods = "testSelectPremiumCashbackCategories")
    public void testOpenLevelPageLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        boolean isTrue = false;
        for (String i : URLS_LIST) {
            if (premiumCashbackPage.openLevelPageLink().contains(i)) {
                isTrue = true;
            }
            break;
        }
        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testOpenLevelPageLink")
    public void testGetLevelPageHeader() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertEquals(premiumCashbackPage.getLevelPageHeader(), PREMIUM_LEVEL_PAGE_HEADER);
    }

    @Test(dependsOnMethods = "testGetLevelPageHeader")
    public void testBackToCashbackPrivilege() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        boolean isTrue = false;
        for (String i : CASHBACK_URL) {
            if (premiumCashbackPage.backToCashbackPrivilege().contains(i)) {
                isTrue = true;
            }
            break;
        }
        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testBackToCashbackPrivilege")
    public void testOpenFirstLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.openFirstLink());
    }

    @Test(dependsOnMethods = "testOpenFirstLink")
    public void testOpenSecondLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.openSecondLink());
    }

    @Test(dependsOnMethods = "testOpenSecondLink")
    public void testOpenThirdLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.openThirdLink());
    }

}
