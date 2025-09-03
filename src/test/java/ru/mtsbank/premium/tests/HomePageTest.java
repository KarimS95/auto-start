package ru.mtsbank.premium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.constans.Constans;
import ru.mtsbank.premium.pages.HomePage;

import java.util.List;

public class HomePageTest extends BaseTest {

    private HomePage homePage;


    @Test
    public void testChekPremiumWidgetName() {
        homePage = new HomePage(driverContainer);

        boolean found = false;
        for(String i : Constans.PREMIUM_WIDGET_NAMES.<String[]>getValue()) {
            if(homePage.checkPremiumWidgetName().contains(i)) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found);
    }

    @Test(dependsOnMethods = "testChekPremiumWidgetName")
    public void testCheckPremiumWidget() {
        homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.checkPremiumWidget());
    }

//    @Test(dependsOnMethods = "testChekPremiumWidgetName")
//    public void testCheckPremiumPage() {
//        homePage = new HomePage(driverContainer);
//
//        Assert.assertEquals(homePage.checkPremiumPage(), PREMIUM_URL);
//    }


}
