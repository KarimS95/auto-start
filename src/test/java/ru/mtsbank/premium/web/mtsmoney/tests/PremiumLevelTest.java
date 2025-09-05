package ru.mtsbank.premium.web.mtsmoney.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.web.mtsmoney.constans.Constans;
import ru.mtsbank.premium.web.mtsmoney.pages.HomePage;
import ru.mtsbank.premium.web.mtsmoney.pages.PremiumLevelPage;
import ru.mtsbank.premium.web.mtsmoney.pages.PremiumPage;

public class PremiumLevelTest extends BaseTest {


    @Test(priority = 1)
    public void testCheckLevelPageHeader() {
        HomePage homePage = new HomePage(driverContainer);
        PremiumPage premiumPage = homePage.openPremiumPage();
        PremiumLevelPage premiumLevelPage = premiumPage.openPremiumLevelPage();

        Assert.assertTrue(premiumLevelPage.getLevelPageHeader().contains(Constans.LEVEL_PAGE_HEADER.getStringValue()));
    }

    @Test(dependsOnMethods = "testCheckLevelPageHeader")
    public void testOpenLevelSheet()  {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertTrue(premiumLevelPage.openLevelSheet().contains(Constans.LEVEL_SHEET_HEADER.getStringValue()));

        premiumLevelPage.closeLevelSheet();
    }

    @Test(dependsOnMethods = "testOpenLevelSheet")
    public void testOpenServicesTermsButton() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertEquals(premiumLevelPage.openServicesTermsListButton(),Constans.LEVEL_TERMS_HEADER);
    }

    @Test(dependsOnMethods = "testOpenServicesTermsButton", groups = "parallel")
    public void testGetCardHeaderTermsList() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);

        Assert.assertEquals(premiumLevelPage.getCardHeaderTermsList(),Constans.LEVEL_TERMS_CARD_HEADER);
    }

    @Test(dependsOnMethods = "testOpenServicesTermsButton", groups = "parallel")
    public void testGetLevelsTermsList() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String termsList = premiumLevelPage.getLevelsTermsList();
        boolean isTrue = termsList.equals(Constans.LEVEL_FIRST_CLIENTS_CASE.getStringValue()) || termsList.equals(Constans.LEVEL_SECOND_CLIENTS_CASE.getStringValue());
        premiumLevelPage.returnBack();

        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnGroups = "parallel")
    public void testOpenFirstI() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String header = premiumLevelPage.openFirstI();
        Assert.assertEquals(header,Constans.LEVEL_FIRST_HEADER);

        premiumLevelPage.closeI();
    }


    @Test(dependsOnMethods = "testOpenFirstI")
    public void testOpenSecond() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String header = premiumLevelPage.openSecondI();
        boolean isTrue = header.contains(Constans.LEVEL_SECOND_HEADER.getStringValue());

        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testOpenSecond")
    public void testGetPurchasesTermsPDF() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String URL = premiumLevelPage.getPurchasesTermsPDF();

        Assert.assertEquals(URL,Constans.LEVEL_PURCHASES_TERMS_PDF_URL);

        premiumLevelPage.closeI();
    }

    @Test(dependsOnMethods = "testGetPurchasesTermsPDF")
    public void testOpenThirdI() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String header = premiumLevelPage.openThirdI();
        boolean isTrue = header.contains(Constans.LEVEL_THIRD_HEADER.getStringValue());

        Assert.assertTrue(isTrue);

        premiumLevelPage.closeI();
    }


    @Test(dependsOnMethods = "testOpenThirdI")
    public void testCheckLevelRulesButton() {
        PremiumLevelPage premiumLevelPage = new PremiumLevelPage(driverContainer);
        String URL = premiumLevelPage.checkLevelRulesButton();
        boolean isTrue = URL.contains(Constans.LEVEL_RULES_PDF_URL.getStringValue());

        Assert.assertTrue(isTrue);
    }




}
