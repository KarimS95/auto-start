package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.premium.pages.HomePage;

import java.util.Arrays;
import java.util.List;

public class HomePageTest extends BaseTest {

    private static final String BASE_URL = "https://online.mtsdengi-test.mbrd.ru/";
    private static final String PREMIUM_URL = "https://online.mtsdengi-test.mbrd.ru/premium";
    private static final List<String> WIDGET_NAMES = List.of("Премиум", "Premium", "Прайвет", "Private");

    private HomePage homePage;


    @Test
    public void testChekPremiumWidgetName() {
        homePage = new HomePage(driverContainer);

        boolean found = false;
        for(String i : WIDGET_NAMES) {
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
