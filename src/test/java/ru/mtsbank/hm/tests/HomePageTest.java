package ru.mtsbank.hm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.ForgotPasswordPage;
import ru.mtsbank.hm.pages.HomePage;
import ru.mtsbank.hm.pages.RegisterPage;

public class HomePageTest extends BaseTest {

    //For RegisterPage


    @Test
    public void testIsPagesLinkDisplayed() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isRegisterPageLinkDisplayed());
        Assert.assertTrue(homePage.isForgotPasswordPageLinkDisplayed());
        Assert.assertTrue(homePage.isOTPPageLinkDisplayed());
    }

    @Test(dependsOnMethods = "testIsPagesLinkDisplayed")
    public void testGetPagesCardText() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getRegisterPageCardText(), HOME_PAGE_REG_PAGE_CARD_TEXT);
        Assert.assertEquals(homePage.getForgotPasswordPageCardText(), HOME_PAGE_FORGOT_PASS_PAGE_CARD_TEXT);
    }

    @Test(dependsOnMethods = "testGetPagesCardText")
    public void testIsPagesButtonsDisplayed() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isRegisterPageButtonDisplayed());
        Assert.assertTrue(homePage.isForgotPasswordPageButtonDisplayed());
    }

    @Test(dependsOnMethods = "testIsPagesButtonsDisplayed")
    public void testGetPagesButtonsText() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getRegisterPageButtonText(), HOME_PAGE_BUTTON_TEXT);
        Assert.assertEquals(homePage.getForgotPasswordPageButtonText(), HOME_PAGE_BUTTON_TEXT);
    }

    @Test(dependsOnMethods = "testGetPagesButtonsText")
    public void testOpenRegisterPageWithClickOnLink() {
        HomePage homePage = new HomePage(driverContainer);
        RegisterPage registerPage = homePage.openRegisterPageWithClickOnLink();

        Assert.assertEquals(registerPage.getRegisterPageUrl(), REGISTER_PAGE_URL);
    }

    @Test(dependsOnMethods = "testOpenRegisterPageWithClickOnLink")
    public void testClickBackButtonToHomePage() {
        RegisterPage registerPage = new RegisterPage(driverContainer);
        HomePage homePage = registerPage.clickBackButtonToHomePageFromRegisterPage();

        Assert.assertEquals(homePage.getHomePageUrl(),HOME_PAGE_URL);
    }

    @Test(dependsOnMethods = "testClickBackButtonToHomePage")
    public void testOpenRegisterPageWithClickOnButton() {
        HomePage homePage = new HomePage(driverContainer);
        RegisterPage registerPage = homePage.openRegisterPageWithClickOnButton();

        Assert.assertEquals(registerPage.getRegisterPageUrl(), REGISTER_PAGE_URL);
    }


    //For PasswordForgotPage


    @Test(dependsOnMethods = "testOpenRegisterPageWithClickOnButton")
    public void testOpenForgotPasswordPageWithClickOnLink() {
        RegisterPage registerPage = new RegisterPage(driverContainer);
        HomePage homePage = registerPage.clickBackButtonToHomePageFromRegisterPage();
        ForgotPasswordPage forgotPasswordPage = homePage.openForgotPasswordPageWithClickOnLink();

        Assert.assertEquals(forgotPasswordPage.getForgotPasswordPageUrl(), FORGOT_PASSWORD_PAGE_URL);
    }

    @Test(dependsOnMethods = "testOpenForgotPasswordPageWithClickOnLink")
    public void testClickBackButtonToHomePageFromForgotPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);
        HomePage homePage = forgotPasswordPage.clickBackButtonToHomePageFromForgotPasswordPage();

        Assert.assertEquals(homePage.getHomePageUrl(),HOME_PAGE_URL);
    }

    @Test(dependsOnMethods = "testClickBackButtonToHomePageFromForgotPasswordPage")
    public void testOpenForgotPasswordPageWithClickOnButton() {
        HomePage homePage = new HomePage(driverContainer);
        ForgotPasswordPage forgotPasswordPage = homePage.openForgotPasswordPageWithClickOnButton();

        Assert.assertEquals(forgotPasswordPage.getForgotPasswordPageUrl(), FORGOT_PASSWORD_PAGE_URL);
    }

    //For OTPPage


}
