package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumCashbackPage;
import ru.mtsbank.premium.pages.PremiumPage;

import java.util.Arrays;
import java.util.List;

public class PremiumCashbackTest extends BaseTest {

    private static final String[] CASHBACK_HEADER = {"Кешбэк", "кешбэк"};
    private static final int CHECKBOXES_COUNT = 5;
    private static final String[] PREMIUM_LEVEL_PAGE_URL = {"https://online.mtsdengi-test.mbrd.ru/premium/level","https://online.mtsdengi-dev.mbrd.ru/premium/level"};
    private final String PREMIUM_LEVEL_PAGE_HEADER = "Премиальное обслуживание";
    private final String[] CASHBACK_URL = {"https://online.mtsdengi-test.mbrd.ru/premium/cashback", "https://online.mtsdengi-dev.mbrd.ru/premium/cashback"};
    private final String[] PARTNERS_URLS = {"https://vamprivet.ru/supreme-restaurants/","https://vamprivet.ru/afisha/"};
    private final String[] CASHBACK_TERMS_URL = {
            "https://static.mtsdengi.ru/portal-frontend-premium/documents/usloviya-nachisleniya-keshbehka-dlya-debetovyh-kart-v-ramkah.pdf",
            "https://static.mtsdengi.ru/portal-frontend-private-banking/documents/usloviya-nachisleniya-keshbeka-private.pdf"};


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
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenPremiumCashbackCategoriesList")
    public void testGetCheckboxesCount() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        boolean isCheckboxesTrue = (premiumCashbackPage.getCheckboxesCount() >= CHECKBOXES_COUNT);
        Assert.assertTrue(isCheckboxesTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenPremiumCashbackCategoriesList")
    public void testCheckCheckboxes() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkCheckboxes());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenPremiumCashbackCategoriesList")
    public void testCheckDisableSelectButton() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkDisableSelectButton());
    }


    @Test(dependsOnGroups = "parallel")
    public void testSelectPremiumCashbackCategories() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        premiumCashbackPage.selectCashbackCategoriesCheckboxes();

        Assert.assertTrue(premiumCashbackPage.checkDisableCheckboxes());
        Assert.assertTrue(premiumCashbackPage.checkEnableSelectButton());
    }

    @Test(dependsOnMethods = "testSelectPremiumCashbackCategories")
    public void testClickOnCategoriesSelectButton() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        premiumCashbackPage.clickOnCategoriesSelectButton();

        Assert.assertTrue(premiumCashbackPage.checkSelectButton());
    }

    @Test(dependsOnMethods = "testClickOnCategoriesSelectButton")
    public void testClickOnSuccessfulButton() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        premiumCashbackPage.clickOnSuccessfulButton();

        Assert.assertTrue(premiumCashbackPage.checkSelectedCategories());

        boolean isTrue = false;
        for (String i : CASHBACK_URL) {
            if (premiumCashbackPage.getPremiumCashbackPageURL().equals(i)) {
                isTrue = true;
                break;
            }
        }

        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testClickOnSuccessfulButton")
    public void testOpenLevelPageLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        String URL = premiumCashbackPage.openLevelPageLink();

        boolean isTrue = false;
        for (String i : PREMIUM_LEVEL_PAGE_URL) {
            if (URL.equals(i)) {
                isTrue = true;
                break;
            }
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
            if (premiumCashbackPage.backToCashbackPrivilege().equals(i)) {
                isTrue = true;
                break;
            }
        }
        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testBackToCashbackPrivilege")
    public void testOpenFirstLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        String URL = premiumCashbackPage.openFirstLink();

        boolean isTrue = false;
        for (String i : PARTNERS_URLS) {
            if (URL.equals(i)) {
                isTrue = true;
                break;
            }
        }
        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testOpenFirstLink")
    public void testOpenSecondLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        String URL = premiumCashbackPage.openSecondLink();

        boolean isTrue = false;
        for (String i : PARTNERS_URLS) {
            if (URL.equals(i)) {
                isTrue = true;
                break;
            }
        }
        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testOpenSecondLink")
    public void testOpenThirdLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        String URL = premiumCashbackPage.openThirdLink();

        boolean isTrue = false;
        for (String i : CASHBACK_TERMS_URL) {
            if (URL.equals(i)) {
                isTrue = true;
                break;
            }
        }
        Assert.assertTrue(isTrue);
    }

}
