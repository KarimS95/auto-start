package ru.mtsbank.hm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.*;

public class HomePageTest extends BaseTest {

    //For ALL PAGES

//    @Test
//    public void testIsPagesLinkInteractivable() {
//        HomePage homePage = new HomePage(driverContainer);
//
//        Assert.assertTrue(homePage.isRegisterPageLinkInteractivable());
//        Assert.assertTrue(homePage.isForgotPasswordPageLinkInteractivable());
//        Assert.assertTrue(homePage.isOTPPageLinkInteractivable());
//        Assert.assertTrue(homePage.isLoginPageLinkInteractivable());
//    }
//
//    @Test(dependsOnMethods = "testIsPagesLinkInteractivable")
//    public void testGetPagesCardText() {
//        HomePage homePage = new HomePage(driverContainer);
//
//        Assert.assertEquals(homePage.getRegisterPageCardText(), HOME_PAGE_REG_PAGE_CARD_TEXT);
//        Assert.assertEquals(homePage.getForgotPasswordPageCardText(), HOME_PAGE_FORGOT_PASS_PAGE_CARD_TEXT);
//        Assert.assertEquals(homePage.getOTPPageCardText(), OTP_PAGE_CARD_TEXT);
//    }
//
//    @Test(dependsOnMethods = "testGetPagesCardText")
//    public void testIsPagesButtonsInteractivable() {
//        HomePage homePage = new HomePage(driverContainer);
//
//        Assert.assertTrue(homePage.isRegisterPageButtonInteractivable());
//        Assert.assertTrue(homePage.isForgotPasswordPageButtonInteractivable());
//        Assert.assertTrue(homePage.isOtpPageButtonInteractivable());
//        Assert.assertTrue(homePage.isLoginPageButtonInteractivable());
//    }
//
//    @Test(dependsOnMethods = "testIsPagesButtonsInteractivable")
//    public void testGetPagesButtonsText() {
//        HomePage homePage = new HomePage(driverContainer);
//
//        Assert.assertEquals(homePage.getRegisterPageButtonText(), HOME_PAGE_BUTTON_TEXT);
//        Assert.assertEquals(homePage.getForgotPasswordPageButtonText(), HOME_PAGE_BUTTON_TEXT);
//        Assert.assertEquals(homePage.getOtpPageButtonText(), HOME_PAGE_BUTTON_TEXT);
//        Assert.assertEquals(homePage.getLoginPageButtonName(), HOME_PAGE_BUTTON_TEXT);
//    }
//
//    //For LoginPage
//
//    @Test(dependsOnMethods = "testGetPagesButtonsText")
//    public void testOpenLoginPageWithClickOnLink() {
//        HomePage homePage = new HomePage(driverContainer);
//        LoginPage loginPage = homePage.openLoginPageWithClickOnLink();
//
//        Assert.assertEquals(loginPage.getLoginPageUrl(), LOGIN_PAGE_URL);
//    }
//
//    @Test(dependsOnMethods = "testOpenLoginPageWithClickOnLink")
//    public void testClickBackButtonToHomePageFromLoginPage() {
//        HomePage homePage = new HomePage(driverContainer);
//        BasePage basePage = new BasePage(driverContainer);
//        basePage.clickBackButtonToHomePage();
//
//        Assert.assertEquals(homePage.getHomePageUrl(),HOME_PAGE_URL);
//    }
//
//    @Test(dependsOnMethods = "testClickBackButtonToHomePageFromLoginPage")
//    public void testOpenLoginPageWithClickOnButton() {
//        HomePage homePage = new HomePage(driverContainer);
//        LoginPage loginPage = homePage.openLoginPageWithClickOnButton();
//
//        Assert.assertEquals(loginPage.getLoginPageUrl(), LOGIN_PAGE_URL);
//    }
//
//
//    //For RegisterPage
//
//    @Test(dependsOnMethods = "testOpenLoginPageWithClickOnButton")
//    public void testOpenRegisterPageWithClickOnLink() {
//        BasePage basePage = new BasePage(driverContainer);
//        HomePage homePage = basePage.clickBackButtonToHomePage();
//        RegisterPage registerPage = homePage.openRegisterPageWithClickOnLink();
//
//        Assert.assertEquals(registerPage.getRegisterPageUrl(), REGISTER_PAGE_URL);
//    }
//
//    @Test(dependsOnMethods = "testOpenRegisterPageWithClickOnLink")
//    public void testClickBackButtonToHomePageFromRegisterPage() {
//        RegisterPage registerPage = new RegisterPage(driverContainer);
//        HomePage homePage = registerPage.clickBackButtonToHomePageFromRegisterPage();
//
//        Assert.assertEquals(homePage.getHomePageUrl(),HOME_PAGE_URL);
//    }
//
//    @Test(dependsOnMethods = "testClickBackButtonToHomePageFromRegisterPage")
//    public void testOpenRegisterPageWithClickOnButton() {
//        HomePage homePage = new HomePage(driverContainer);
//        RegisterPage registerPage = homePage.openRegisterPageWithClickOnButton();
//
//        Assert.assertEquals(registerPage.getRegisterPageUrl(), REGISTER_PAGE_URL);
//    }
//
//
//    //For PasswordForgotPage
//
//    @Test(dependsOnMethods = "testOpenRegisterPageWithClickOnButton")
//    public void testOpenForgotPasswordPageWithClickOnLink() {
//        RegisterPage registerPage = new RegisterPage(driverContainer);
//        HomePage homePage = registerPage.clickBackButtonToHomePageFromRegisterPage();
//        ForgotPasswordPage forgotPasswordPage = homePage.openForgotPasswordPageWithClickOnLink();
//
//        Assert.assertEquals(forgotPasswordPage.getForgotPasswordPageUrl(), FORGOT_PASSWORD_PAGE_URL);
//    }
//
//    @Test(dependsOnMethods = "testOpenForgotPasswordPageWithClickOnLink")
//    public void testClickBackButtonToHomePageFromForgotPasswordPage() {
//        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);
//        HomePage homePage = forgotPasswordPage.clickBackButtonToHomePageFromForgotPasswordPage();
//
//        Assert.assertEquals(homePage.getHomePageUrl(),HOME_PAGE_URL);
//    }
//
//    @Test(dependsOnMethods = "testClickBackButtonToHomePageFromForgotPasswordPage")
//    public void testOpenForgotPasswordPageWithClickOnButton() {
//        HomePage homePage = new HomePage(driverContainer);
//        ForgotPasswordPage forgotPasswordPage = homePage.openForgotPasswordPageWithClickOnButton();
//
//        Assert.assertEquals(forgotPasswordPage.getForgotPasswordPageUrl(), FORGOT_PASSWORD_PAGE_URL);
//    }


    //For OTPPage

    @Test//(dependsOnMethods = "testOpenForgotPasswordPageWithClickOnButton")
    public void testOpenOTPPageWithClickOnLink() {
//        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);
//        HomePage homePage = forgotPasswordPage.clickBackButtonToHomePageFromForgotPasswordPage();
        HomePage homePage = new HomePage(driverContainer);
        OTPPage otpPage = homePage.openOTPPageWithClickOnLink();

        Assert.assertEquals(otpPage.getOTPPageUrl(), OTP_PAGE_URL);
    }

    @Test(dependsOnMethods = "testOpenOTPPageWithClickOnLink")
    public void testClickBackButtonToHomePageFromOTPPage() {
        OTPPage otpPage = new OTPPage(driverContainer);
        HomePage homePage = otpPage.clickBackButtonToHomePageFromOTPPage();

        Assert.assertEquals(homePage.getHomePageUrl(), HOME_PAGE_URL);
    }

    @Test(dependsOnMethods = "testClickBackButtonToHomePageFromOTPPage")
    public void testOpenOTPPageWithClickOnButton() {
        HomePage homePage = new HomePage(driverContainer);
        OTPPage otpPage = homePage.openOTPPageWithClickOnButton();

        Assert.assertEquals(otpPage.getOTPPageUrl(), OTP_PAGE_URL);
    }



}
