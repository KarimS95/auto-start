package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mtsbank.pages.HomePage;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void getInit() {
        homePage = new HomePage(driverContainer);
    }

    @Test
    public void testCheckPremiumWidget() {
        homePage.checkPremiumWidget();
    }

    @Test//(dependsOnMethods = "testCheckPremiumWidget")
    public void testOpenPremiumPage() { //clickable
        homePage.openPremiumPage();
    }

    @Test(dependsOnMethods = "testOpenPremiumPage")
    public void testReturnToHomePage() {
        homePage.returnToPreviousPage(HomePage.class);
    }

}
