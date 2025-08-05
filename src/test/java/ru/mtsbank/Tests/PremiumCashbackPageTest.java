package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.PremiumCashbackPage;

public class PremiumCashbackPageTest extends BaseTest {

    private PremiumCashbackPage premiumCashbackPage;
    private static final String cashbackCategoriesListUrl = "https://online.mtsdengi-test.mbrd.ru/premium/cashback-category?fromDate=2025-08-01";
    private static final String premiumUrl = "https://online.mtsdengi-test.mbrd.ru/premium";
    private static final String premiumCashbackUrl = "https://online.mtsdengi-test.mbrd.ru/premium/cashback";
    private final static String premiumLevelUrl = "https://online.mtsdengi-test.mbrd.ru/premium/level";

    @BeforeMethod
    public void objectInstance() {
     premiumCashbackPage = new PremiumCashbackPage(driverContainer);
    }

    @Test
    public void testOpenPremiumCashbackCategoriesList() {
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
    public void testCheckLevelPageLink() {
        premiumCashbackPage.checkLevelPageLink();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(), premiumLevelUrl);
        Assert.assertEquals(driverContainer.get().getCurrentUrl(), premiumCashbackUrl);
    }

}
