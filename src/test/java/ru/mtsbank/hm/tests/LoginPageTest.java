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

        Assert.assertEquals(loginPage.getLoginPageUrl(), LOGIN_PAGE_URL);
    }

    @Test(dependsOnMethods = "testOpenLoginPage")
    public void testGetLoginPageCardHeader() {
        LoginPage loginPage = new LoginPage(driverContainer);

        Assert.assertEquals(loginPage.getLoginPageCardHeader(), LOGIN_PAGE_CARD_HEADER);
    }

    @Test(dependsOnMethods = "testGetLoginPageCardHeader")
    public void testGetUsernameFieldName() {
        LoginPage loginPage = new LoginPage(driverContainer);

        Assert.assertEquals(loginPage.getUsernameFieldName(), USERNAME_FIELD);
    }

    @Test(dependsOnMethods = "testGetUsernameFieldName")
    public void testGetPasswordFieldName() {
        LoginPage loginPage = new LoginPage(driverContainer);

        Assert.assertEquals(loginPage.getPasswordFieldName(), PASSWORD_FIELD);
    }

    @Test(dependsOnMethods = "testGetPasswordFieldName")
    public void testGetLoginButtonText() {
        LoginPage loginPage = new LoginPage(driverContainer);

        Assert.assertEquals(loginPage.getLoginButtonText(), LOGIN_BUTTON);
    }

    @Test(dependsOnMethods = "testGetLoginButtonText")
    public void testIsRegisterLinkInteractive() {
        LoginPage loginPage = new LoginPage(driverContainer);

        Assert.assertTrue(loginPage.isRegisterLinkInteractive());
    }

    @Test(dependsOnMethods = "testIsRegisterLinkInteractive")
    public void testIsLoginButtonInteractive() {
        LoginPage loginPage = new LoginPage(driverContainer);

        Assert.assertTrue(loginPage.isLoginButtonInteractive());
    }

    @Test(dependsOnMethods = "testIsLoginButtonInteractive")
    public void testCheckUsernameField() {
        LoginPage loginPage = new LoginPage(driverContainer);

        Assert.assertTrue(loginPage.checkUsernameField());
    }

    @Test(dependsOnMethods = "testCheckUsernameField")
    public void testCheckPasswordField() {
        LoginPage loginPage = new LoginPage(driverContainer);

        Assert.assertTrue(loginPage.checkPasswordField());
    }

    @Test(dependsOnMethods = "testCheckPasswordField")
    public void testGetLoginPageCardText() {
        LoginPage loginPage = new LoginPage(driverContainer);

        boolean isTrue = false;
        for (String i : LOGIN_PAGE_CARD_TEXT) {
            if (loginPage.getLoginPageCardText().contains(i)) {
                isTrue = true;
            }
        }
        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testGetLoginPageCardText", dataProvider = "negativeValues")
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


        Assert.assertEquals(securePage.getSecurePageUrl(), SECURE_URL);
        Assert.assertEquals(securePage.getAlert(), LOGGED_IN);
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
