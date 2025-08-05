package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.PremiumCashbackPage;
import ru.mtsbank.pages.PremiumPage;

public class PremiumCashbackPageTest extends BaseTest {

    private static final String cashbackCategoriesListUrl = "https://online.mtsdengi-test.mbrd.ru/premium/cashback-category?fromDate=2025-08-01";
    private static final String premiumUrl = "https://online.mtsdengi-test.mbrd.ru/premium";
    private static final String premiumCashbackUrl = "https://online.mtsdengi-test.mbrd.ru/premium/cashback";
    private static final String premiumLevelUrl = "https://online.mtsdengi-test.mbrd.ru/premium/level";
    private static final String firstLink = "https://vamprivet.ru/supreme-restaurants/";

    private PremiumPage premiumPage;
    private PremiumCashbackPage premiumCashbackPage;

    @BeforeMethod
    public void objectInstance() {
        premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        premiumPage = new PremiumPage(driverContainer);
    }

    @Test
    public void testOpenPremiumCashbackCategoriesList() {

        premiumPage.openPremiumPage();

        premiumCashbackPage.openPremiumCashbackCategoriesList();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(),cashbackCategoriesListUrl);
    }

    @Test(dependsOnMethods = "testOpenPremiumCashbackCategoriesList")
    public void testSelectCashbackCategories() {
        premiumCashbackPage.selectCashbackCategories();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(), premiumUrl);
    }

    @Test(dependsOnMethods = "testSelectCashbackCategories")
    public void testOpenCashbackPrivilege() {
        premiumCashbackPage.openPremiumCashbackPrivilege();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(), premiumCashbackUrl);
    }

    @Test(dependsOnMethods = "testOpenCashbackPrivilege")
    public void testCheckLevelPageLink() throws InterruptedException {
        premiumCashbackPage.checkLevelPageLink();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(), premiumCashbackUrl);
    }

    @Test(dependsOnMethods = "testCheckLevelPageLink")
    public void testCheckFirstLink() throws InterruptedException {
        premiumCashbackPage.checkFirstLink();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(), firstLink);
    }

}
