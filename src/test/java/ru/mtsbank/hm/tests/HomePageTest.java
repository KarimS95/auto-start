package ru.mtsbank.hm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.*;

public class HomePageTest extends BaseTest {

    //ALL PAGES

    @Test
    public void testCheckLoginPageLink() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isLoginPageLinkInteractive());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testCheckLoginPageButton() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isLoginPageButtonInteractive());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testGetLoginPageButtonName() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getLoginPageButtonName(), HOME_PAGE_BUTTON_TEXT);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testCheckRegisterPageLink() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isRegisterPageLinkInteractive());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testCheckRegisterPageButton() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isRegisterPageButtonInteractive());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testGetLoginPageCardText() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getLoginPageCardText(), HOME_PAGE_LOGIN_PAGES_CARD_TEXT);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testGetRegisterPageCardText() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getRegisterPageCardText(), HOME_PAGE_REG_PAGE_CARD_TEXT);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testGetRegisterPageButtonText() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getRegisterPageButtonText(), HOME_PAGE_BUTTON_TEXT);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testCheckForgotPasswordPageLink() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isForgotPasswordPageLinkInteractive());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testCheckForgotPasswordPageButton() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isForgotPasswordPageButtonInteractive());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void tesGetForgotPasswordPageCardText() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getForgotPasswordPageCardText(), HOME_PAGE_FORGOT_PASS_PAGE_CARD_TEXT);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testGetForgotPasswordPageButtonText() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getForgotPasswordPageButtonText(), HOME_PAGE_BUTTON_TEXT);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testCheckOTPPageLink() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isOTPPageLinkInteractive());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testCheckOTPPageButton() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertTrue(homePage.isOtpPageButtonInteractive());
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testGetOTPPageCardText() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getOTPPageCardText(), OTP_PAGE_CARD_TEXT);
    }

    @Test(groups = "parallel", dependsOnMethods = "testCheckLoginPageLink")
    public void testGetOTPPageButtonText() {
        HomePage homePage = new HomePage(driverContainer);

        Assert.assertEquals(homePage.getOTPPageButtonText(), HOME_PAGE_BUTTON_TEXT);
    }

    //LoginPage

    @Test(dependsOnGroups = "parallel")
    public void testOpenLoginPageWithClickOnLink() {
        HomePage homePage = new HomePage(driverContainer);
        LoginPage loginPage = homePage.openLoginPageWithClickOnLink();

        Assert.assertEquals(loginPage.getLoginPageUrl(), LOGIN_PAGE_URL);
    }

    @Test(dependsOnMethods = "testOpenLoginPageWithClickOnLink")
    public void testClickBackButtonToHomePageFromLoginPage() {
        HomePage homePage = new HomePage(driverContainer);
        BasePage basePage = new BasePage(driverContainer);
        basePage.clickBackButtonToHomePage();

        Assert.assertEquals(homePage.getHomePageUrl(),HOME_PAGE_URL);
    }

    @Test(dependsOnMethods = "testClickBackButtonToHomePageFromLoginPage")
    public void testOpenLoginPageWithClickOnButton() {
        HomePage homePage = new HomePage(driverContainer);
        LoginPage loginPage = homePage.openLoginPageWithClickOnButton();

        Assert.assertEquals(loginPage.getLoginPageUrl(), LOGIN_PAGE_URL);
    }

    //RegisterPage

    @Test(dependsOnMethods = "testOpenLoginPageWithClickOnButton")
    public void testOpenRegisterPageWithClickOnLink() {
        BasePage basePage = new BasePage(driverContainer);
        HomePage homePage = basePage.clickBackButtonToHomePage();
        RegisterPage registerPage = homePage.openRegisterPageWithClickOnLink();

        Assert.assertEquals(registerPage.getRegisterPageUrl(), REGISTER_PAGE_URL);
    }

    @Test(dependsOnMethods = "testOpenRegisterPageWithClickOnLink")
    public void testClickBackButtonToHomePageFromRegisterPage() {
        RegisterPage registerPage = new RegisterPage(driverContainer);
        HomePage homePage = registerPage.clickBackButtonToHomePageFromRegisterPage();

        Assert.assertEquals(homePage.getHomePageUrl(),HOME_PAGE_URL);
    }

    @Test(dependsOnMethods = "testClickBackButtonToHomePageFromRegisterPage")
    public void testOpenRegisterPageWithClickOnButton() {
        HomePage homePage = new HomePage(driverContainer);
        RegisterPage registerPage = homePage.openRegisterPageWithClickOnButton();

        Assert.assertEquals(registerPage.getRegisterPageUrl(), REGISTER_PAGE_URL);
    }

    //PasswordForgotPage

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

    //OTPPage

    @Test(dependsOnMethods = "testOpenForgotPasswordPageWithClickOnButton")
    public void testOpenOTPPageWithClickOnLink() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);
        HomePage homePage = forgotPasswordPage.clickBackButtonToHomePageFromForgotPasswordPage();
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
