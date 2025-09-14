package ru.mtsbank.premium.web.mtsmoney.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.web.mtsmoney.constans.Constans;
import ru.mtsbank.premium.web.mtsmoney.pages.HomePage;

public class HomePageTest extends BaseTest {

    private HomePage homePage;


    @Test
    public void testCheсkPremiumWidgetName() {
        homePage = new HomePage(driverContainer);

        boolean found = false;
        for(String i : Constans.PREMIUM_WIDGET_NAMES.getArrayStringValue()) {
            if(homePage.checkPremiumWidgetName().contains(i)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
    }

    @Test(dependsOnMethods = "testCheсkPremiumWidgetName")
    public void testCheckPremiumWidget() {
        homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.checkPremiumWidget());
    }

//    @Test(dependsOnMethods = "testCheсkPremiumWidgetName")
//    public void testCheckPremiumPage() {
//        homePage = new HomePage(driverContainer);
//
//        Assert.assertEquals(homePage.checkPremiumPage(), PREMIUM_URL);
//    }


}
