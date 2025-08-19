package ru.mtsbank.hm.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.HomePage;
import ru.mtsbank.hm.pages.LoginPage;
import ru.mtsbank.hm.pages.SecurePage;



public class LoginPageTest extends BaseTest {


    @Test
    public void testOpenLoginPage() {
        HomePage homePage = new HomePage(driverContainer);
        LoginPage loginPage = homePage.openLoginPageWithClickOnLink();

        boolean isTrue = false;
        for (String i : LOGIN_PAGE_CARD_TEXT) {
            if (loginPage.getLoginPageCardText().contains(i)) {
                isTrue = true;
            }
        }

        Assert.assertTrue(isTrue);
        Assert.assertEquals(loginPage.getLoginPageUrl(), LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.getLoginPageCardHeader(), LOGIN_PAGE_CARD_HEADER);
        Assert.assertTrue(loginPage.checkRegisterLink());
        Assert.assertTrue(loginPage.checkUsernameField());
        Assert.assertTrue(loginPage.checkPasswordField());
        Assert.assertTrue(loginPage.checkLoginButton());
        Assert.assertEquals(loginPage.getUsernameFieldName(), USERNAME_FIELD);
        Assert.assertEquals(loginPage.getPasswordFieldName(), PASSWORD_FIELD);
        Assert.assertEquals(loginPage.getLoginButtonText(), LOGIN_BUTTON);
    }

    @Test(dependsOnMethods = "testOpenLoginPage", dataProvider = "negativeValues")
    public void testNegativeLogin(int number, String username, String password) {
        LoginPage loginPage = new LoginPage(driverContainer);

        switch (number) {
            case 1, 3 -> {
                loginPage.inputUsername(username);
                loginPage.inputPassword(password);
                loginPage.clickLoginButton();
                Assert.assertEquals(loginPage.alert(), INVALID_USERNAME);
            }
            case 2 -> {
                loginPage.inputUsername(username);
                loginPage.inputPassword(password);
                loginPage.clickLoginButton();
                Assert.assertEquals(loginPage.alert(), INVALID_PASSWORD);
            }
        }
    }

    @Test(dependsOnMethods = "testNegativeLogin", dataProvider = "positiveValues")
    public void testPositiveLogin(String username, String password) {
        LoginPage loginPage = new LoginPage(driverContainer);
        SecurePage securePage = loginPage.login(username, password);

        boolean isTrue = false;
        for (String i: SECURE_PAGE_TEXT) {
            if(securePage.getSecurePageTextInfo().contains(i)) {
                isTrue = true;
            }
        }

        Assert.assertEquals(securePage.getSecureUrl(), SECURE_URL);
        Assert.assertEquals(securePage.getAlert(), LOGGED_IN);
        Assert.assertEquals(securePage.getLogoutButtonText(), LOGOUT_BUTTON_SP);
        Assert.assertTrue(isTrue);
        Assert.assertTrue(securePage.isLogoutButtonInteractable());
    }




    @DataProvider(name = "negativeValues")
    public Object[][] negativeValues() {
        return new Object[][] {
                {1,"",""},
                {2,"test",""},
                {3,"","test"}
        };
    }

    @DataProvider(name = "positiveValues")
    public Object[][] positiveValues() {
        return new Object[][] {
                {"practice","SuperSecretPassword!"}
        };
    }



}
