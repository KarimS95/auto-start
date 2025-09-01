package ru.mtsbank.hw.tests;

import org.openqa.selenium.ElementClickInterceptedException;
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
        RegisterPage registerPage = null;
        for (int i = 0; i < MAX_RETRIES; i++) {
         try {
            registerPage = homePage.openRegisterPageWithClickOnLink();
            break;
         } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
             System.out.println("Retries: " + i);
         }
        }
        Assert.assertEquals(registerPage.getRegisterPageUrl(), REGISTER_PAGE_URL);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenRegisterPage")
    public void testGetRegisterPageHeader() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertTrue(registerPage.getRegisterPageHeader());
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
    public void testInputInvalidCredentials(String username, String password, String confirmPassword, String expectedResult) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        for(int i = 0; i < MAX_RETRIES; i++) {
            try {
                registerPage.inputUsername(username); registerPage.inputPassword(password); registerPage.inputConfirmPassword(confirmPassword);
                registerPage.clickRegisterButton();
                Assert.assertEquals(registerPage.getAlert(), expectedResult);
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
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
                { ".", ".", ".", SHORT_USERNAME},
                {"test", "1", "1", SHORT_PASSWORD},
                {"test", "123", "123", SHORT_PASSWORD},
                {"тест", "1234", "1234", WRONG_USERNAME},
                {"testtesttesttesttesttesttesttesttesttest", "1234", "1234", WRONG_USERNAME},
                {"test", "1234", "test", DIFFERENT_PASSWORDS},
                {"practice", "SuperSecretPassword!", "SuperSecretPassword!", SAME_CREDS}
        };
    }

    @DataProvider(name = "validICredentials")
    public Object[][] validCredentials() {
      return new Object[][] {
              {"karimtesttesttestte2st11","12345aaakk", "12345aaakk"}
      };
    }



}
