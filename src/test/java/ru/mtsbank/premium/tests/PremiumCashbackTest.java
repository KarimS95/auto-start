package ru.mtsbank.premium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.constans.Constans;
import ru.mtsbank.premium.pages.HomePage;
import ru.mtsbank.premium.pages.PremiumCashbackPage;
import ru.mtsbank.premium.pages.PremiumPage;

public class PremiumCashbackTest extends BaseTest {


    @Test
    public void testGetBaseCashbackBlockHeader() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        PremiumCashbackPage premiumCashbackPage = premiumPage.openPremiumCashbackPrivilege();

        Assert.assertEquals(premiumCashbackPage.getBaseCashbackBlockHeader(), Constans.CASHBACK_BASE_CASHBACK_BLOCK_HEADER.getStringValue());
    }

    @Test(groups = "parallel", dependsOnMethods = "testGetBaseCashbackBlockHeader")
    public void testGetIncreasedCashbackBlockHeader() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertEquals(premiumCashbackPage.getIncreasedCashbackBlockHeader(), Constans.CASHBACK_INCREASED_CASHBACK_BLOCK_HEADER.getStringValue());
    }

    @Test(groups = "parallel", dependsOnMethods = "testGetBaseCashbackBlockHeader")
    public void testGetSubscriptionBlockHeader() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertEquals(premiumCashbackPage.getSubscriptionBlockHeader(), Constans.CASHBACK_SUBSCRIPTION_BLOCK_HEADER.getStringValue());
    }

    @Test(groups = "parallel", dependsOnMethods = "testGetBaseCashbackBlockHeader")
    public void testGetFromPaymentSystemBlockHeder() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertEquals(premiumCashbackPage.getFromPaymentSystemBlockHeder(), Constans.CASHBACK_FROM_PAYMENT_SYSTEM_BLOCK_HEADER.getStringValue());
    }

    @Test(groups = "parallel", dependsOnMethods = "testGetBaseCashbackBlockHeader")
    public void testGetHowToGetBlockHeader() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertEquals(premiumCashbackPage.getHowToGetBlockHeader(), Constans.CASHBACK_HOW_TO_GET_BLOCK_HEADER.getStringValue());
    }

    @Test(groups = "parallel", dependsOnMethods = "testGetBaseCashbackBlockHeader")
    public void testCheckSelectCashbackCategoriesButton() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkSelectCashbackCategoriesButton());
    }

    @Test(dependsOnGroups = "parallel")
    public void testOpenLevelPageLink() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        String URL = premiumCashbackPage.openLevelPageLink();

        boolean isTrue = false;
        for (String i : Constans.LEVEL_PAGE_URLS.getArrayStringValue()) {
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

        Assert.assertEquals(premiumCashbackPage.getLevelPageHeader(), Constans.LEVEL_PAGE_HEADER.getStringValue());
    }

    @Test(dependsOnMethods = "testGetLevelPageHeader")
    public void testBackToCashbackPrivilege() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        String URL = premiumCashbackPage.backToCashbackPrivilege();

        boolean isTrue = false;
        for (String i : Constans.CASHBACK_URLS.getArrayStringValue()) {
            if (URL.equals(i)) {
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
        for (String i : Constans.CASHBACK_PARTNERS_URLS.getArrayStringValue()) {
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
        for (String i : Constans.CASHBACK_PARTNERS_URLS.getArrayStringValue()) {
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
        for (String i : Constans.CASHBACK_TERMS_URLS.getArrayStringValue()) {
            if (URL.equals(i)) {
                isTrue = true;
                break;
            }
        }
        Assert.assertTrue(isTrue);
    }


    @Test(dependsOnMethods = "testOpenThirdLink")
    public void testOpenPremiumCashbackCategoriesList() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);
        premiumCashbackPage.openCategoriesList();
        String HEADER = premiumCashbackPage.getCategoriesListHeader();

        boolean isHeaderTrue = false;
        for(String i : Constans.CASHBACK_HEADER.getArrayStringValue()) {
            if(HEADER.contains(i)) {
                isHeaderTrue = true;
                break;
            }
        }

        Assert.assertTrue(isHeaderTrue);
    }

    @Test(groups = "second-parallel", dependsOnMethods = "testOpenPremiumCashbackCategoriesList")
    public void testGetCheckboxesCount() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        boolean isCheckboxesTrue = (premiumCashbackPage.getCheckboxesCount() >= Constans.CASHBACK_CHECKBOXES_COUNT.getIntValue());
        Assert.assertTrue(isCheckboxesTrue);
    }

    @Test(groups = "second-parallel", dependsOnMethods = "testOpenPremiumCashbackCategoriesList")
    public void testCheckCheckboxes() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkCheckboxes());
    }

    @Test(groups = "second-parallel", dependsOnMethods = "testOpenPremiumCashbackCategoriesList")
    public void testCheckDisableSelectButton() {
        PremiumCashbackPage premiumCashbackPage = new PremiumCashbackPage(driverContainer);

        Assert.assertTrue(premiumCashbackPage.checkDisableSelectButton());
    }


    @Test(dependsOnGroups = "second-parallel")
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

        String URL = premiumCashbackPage.getPremiumCashbackPageURL();

        boolean isTrue = false;
        for (String i : Constans.CASHBACK_URLS.getArrayStringValue()) {
            if (URL.equals(i)) {
                isTrue = true;
                break;
            }
        }

        Assert.assertTrue(isTrue);
    }



}
