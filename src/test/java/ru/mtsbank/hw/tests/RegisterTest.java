package ru.mtsbank.hw.tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.hw.pages.HomePage;
import ru.mtsbank.hw.pages.RegisterPage;

public class RegisterTest extends BaseTest {


    @Test
    public void testOpenRegisterPage() {
        HomePage homePage = new HomePage(driverContainer);
        RegisterPage registerPage = homePage.openRegisterPageWithClickOnLink();

        Assert.assertEquals(registerPage.getRegisterPageUrl(), REGISTER_PAGE_URL);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testGetRegisterPageHeader() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertTrue(registerPage.getRegisterPageHeader());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testGetRegisterPageFooter() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        boolean footerIsTrue = false;
        for (String i : FOOTER) {
            if(registerPage.getRegisterPageFooter().contains(i)) {
                footerIsTrue = true;
            }
        }
        Assert.assertTrue(footerIsTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testGetShowRegisterPageTextInfo() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        boolean textInfoIsTrue = false;
        for (String i : REGISTER_PAGE_TEXT_INFO) {
            if(registerPage.getShowRegisterPageTextInfo().contains(i)) {
                textInfoIsTrue = true;
            }
        }
        Assert.assertTrue(textInfoIsTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testGetShowBackButtonToHomePage() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.getShowBackButtonToHomePage(), BACK_BUTTON);
    }


    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testGetUsernameFieldName() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.getUsernameFieldName(), USERNAME_FIELD);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testGetPasswordFieldName() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.getPasswordFieldName(), PASSWORD_FIELD);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testGetConfirmPasswordFieldName() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.checkConfirmPasswordFieldName(),PASSWORD_CONFIRM_FIELD);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testGetRegisterButtonName() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.getRegisterButtonName(), REGISTER_BUTTON);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testIsUsernameFieldInteractive() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertTrue(registerPage.checkUsernameField());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testIsPasswordFieldInteractive() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertTrue(registerPage.checkPasswordField());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testIsConfirmPasswordFieldInteractive() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertTrue(registerPage.checkConfirmPasswordField());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testIsRegistrationButtonInteractive() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertTrue(registerPage.isRegistrationButtonInteractive());
    }


    @Test(dependsOnGroups = "parallel")
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
              {"karimtesttesttesttest11","12345aaakk", "12345aaakk"}
      };
    }



}
