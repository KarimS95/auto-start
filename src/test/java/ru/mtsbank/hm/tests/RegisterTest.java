package ru.mtsbank.hm.tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.HomePage;
import ru.mtsbank.hm.pages.RegisterPage;

public class RegisterTest extends BaseTest {


    @Test
    public void testOpenRegisterPage() {
        HomePage homePage = new HomePage(driverContainer);
        RegisterPage registerPage = homePage.openRegisterPageWithClickOnLink();

        boolean footerIsTrue = false;
        for (String i : FOOTER) {
            if(registerPage.getRegisterPageFooter().contains(i)) {
                footerIsTrue = true;
            }
        }

        boolean textInfoIsTrue = false;
        for (String i : REGISTER_PAGE_TEXT_INFO) {
            if(registerPage.getShowRegisterPageTextInfo().contains(i)) {
                textInfoIsTrue = true;
            }
        }

        Assert.assertEquals(registerPage.getRegisterPageUrl(), REGISTER_PAGE_URL);
        Assert.assertTrue(registerPage.getRegisterPageHeader());
        Assert.assertTrue(footerIsTrue);
        Assert.assertEquals(registerPage.getShowBackButtonToHomePage(), BACK_BUTTON);
        Assert.assertTrue(textInfoIsTrue);
        Assert.assertEquals(registerPage.getUsernameFieldName(), USERNAME_FIELD);
        Assert.assertTrue(registerPage.checkUsernameField());
        Assert.assertEquals(registerPage.getPasswordFieldName(), PASSWORD_FIELD);
        Assert.assertTrue(registerPage.checkPasswordField());
        Assert.assertEquals(registerPage.checkConfirmPasswordFieldName(),PASSWORD_CONFIRM_FIELD);
        Assert.assertTrue(registerPage.checkConfirmPasswordField());
        Assert.assertEquals(registerPage.checkRegisterButtonName(), REGISTER_BUTTON);
        Assert.assertTrue(registerPage.isRegistrationButtonInteractive());
    }

    @Test(dependsOnMethods = "testOpenRegisterPage")
    public void testClickRegistrationButtonWithVoidFieldValues() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getAlert(), ALL_FIELDS_ARE_REQUIRED);
    }

    @Test(dependsOnMethods = "testClickRegistrationButtonWithVoidFieldValues", dataProvider = "inputValues")
    public void testInputUsername(String value) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        registerPage.inputUsername(value);
        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getAlert(), ALL_FIELDS_ARE_REQUIRED);
    }

    @Test(dependsOnMethods = "testInputUsername", dataProvider = "inputValues")
    public void testInputPassword(String value) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        registerPage.inputPassword(value);
        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getAlert(), ALL_FIELDS_ARE_REQUIRED);
    }

    @Test(dependsOnMethods = "testInputPassword", dataProvider = "inputValues")
    public void testInputConfirmPassword(String value) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        registerPage.inputConfirmPassword(value);
        registerPage.clickRegisterButton();

        Assert.assertEquals(registerPage.getAlert(), ALL_FIELDS_ARE_REQUIRED);
    }

    @Test(dependsOnMethods = "testInputConfirmPassword", dataProvider = "invalidCredentials")
    public void testInputInvalidCredentials(int number, String username, String password, String confirmPassword) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        for(int i = 0; i < MAX_RETRIES; i++) {
            try {
                switch (number) {
                    case 1 -> {
                        registerPage.inputUsername(username); registerPage.inputPassword(password); registerPage.inputConfirmPassword(confirmPassword);
                        registerPage.clickRegisterButton();
                    Assert.assertEquals(registerPage.getAlert(), SHORT_USERNAME);}
                    case 2, 3 -> {
                        registerPage.inputUsername(username); registerPage.inputPassword(password); registerPage.inputConfirmPassword(confirmPassword);
                        registerPage.clickRegisterButton();
                    Assert.assertEquals(registerPage.getAlert(),SHORT_PASSWORD);}
                    case 4, 5 -> {
                        registerPage.inputUsername(username); registerPage.inputPassword(password); registerPage.inputConfirmPassword(confirmPassword);
                        registerPage.clickRegisterButton();
                    Assert.assertEquals(registerPage.getAlert(), WRONG_USERNAME);}
                    case 6 -> {
                        registerPage.inputUsername(username); registerPage.inputPassword(password); registerPage.inputConfirmPassword(confirmPassword);
                        registerPage.clickRegisterButton();
                    Assert.assertEquals(registerPage.getAlert(), DIFFERENT_PASSWORDS);}
                    case 7 -> {
                        registerPage.inputUsername(username); registerPage.inputPassword(password); registerPage.inputConfirmPassword(confirmPassword);
                        registerPage.clickRegisterButton();
                    Assert.assertEquals(registerPage.getAlert(), SAME_CREDS);}
                    default -> throw new IllegalStateException("Unexpected value: " + number);
                }
                break;
            } catch (StaleElementReferenceException e) {
                System.err.println("Retries: " + i);
            }
        }
    }

    @Test(dependsOnMethods = "testInputInvalidCredentials", dataProvider = "validICredentials")
    public void testSuccessfulRegistration(String username, String password, String confirmPassword) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        registerPage.registration(username,password,confirmPassword);

        Assert.assertEquals(registerPage.getAlert(), VALID_CREDS);
        Assert.assertEquals(driverContainer.get().getCurrentUrl(),LOGIN_PAGE_URL);
    }


    @DataProvider(name = "inputValues")
    public Object[][] values() {
        return new Object[][] {
                {"test"}
        };
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {1, ".", ".", "."},
                {2, "test", "1", "1"},
                {3, "test", "123", "123"},
                {4, "тест", "1234", "1234"},
                {5, "testtesttesttesttesttesttesttesttesttest", "1234", "1234"},
                {6, "test", "1234", "test"},
                {7, "practice", "SuperSecretPassword!", "SuperSecretPassword!"}
        };
    }

    @DataProvider(name = "validICredentials")
    public Object[][] validCredentials() {
      return new Object[][] {
              {"karimtesttesttesttest","12345aaakk", "12345aaakk"}
      };
    }



}
