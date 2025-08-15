package ru.mtsbank.hm.tests;

import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.HomePage;
import ru.mtsbank.hm.pages.RegisterPage;

public class RegisterPageTest extends BaseTest {


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
    }

    @Test(dependsOnMethods = "testOpenRegisterPage")
    public void testCheckUsernameField() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.getUsernameFieldName(), USERNAME_FIELD);
        Assert.assertTrue(registerPage.checkUsernameField());
    }

    @Test(dependsOnMethods = "testCheckUsernameField")
    public void testCheckPasswordField() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.getPasswordFieldName(), PASSWORD_FIELD);
        Assert.assertTrue(registerPage.checkPasswordField());
    }

    @Test(dependsOnMethods = "testCheckPasswordField")
    public void testCheckConfirmPasswordFieldName() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.checkConfirmPasswordFieldName(),PASSWORD_CONFIRM_FIELD);
        Assert.assertTrue(registerPage.checkConfirmPasswordField());
    }

    @Test(dependsOnMethods = "testCheckConfirmPasswordFieldName")
    public void testCheckRegisterButtonName() {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.checkRegisterButtonName(), REGISTER_BUTTON);
    }

    @Test(dependsOnMethods = "testCheckRegisterButtonName", dataProvider = "inputValues")
    public void testInputUsername(String value) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.inputUsername(value), ALL_FIELDS_ARE_REQUIRED);
    }

    @Test(dependsOnMethods = "testInputUsername", dataProvider = "inputValues")
    public void testInputPassword(String value) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.inputPassword(value), ALL_FIELDS_ARE_REQUIRED);
    }

    @Test(dependsOnMethods = "testInputPassword", dataProvider = "inputValues")
    public void testInputConfirmPassword(String value) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        Assert.assertEquals(registerPage.inputConfirmPassword(value), ALL_FIELDS_ARE_REQUIRED);
    }

    @Test(dependsOnMethods = "testInputConfirmPassword", dataProvider = "invalidCredentials")
    public void testInputInvalidCredentials(int number, String expectedResult) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        for(int i = 0; i < MAX_RETRIES; i++) {
            try {
                String actualResult = switch (number) {
                    case 1 -> registerPage.inputInvalidCredentials(".", ".", ".");
                    case 2 -> registerPage.inputInvalidCredentials("test", "1", "1");
                    case 3 -> registerPage.inputInvalidCredentials("test", "123", "123");
                    case 4 -> registerPage.inputInvalidCredentials("тест", "1234", "1234");
                    case 5 -> registerPage.inputInvalidCredentials("testtesttesttesttesttesttesttesttesttest", "1234", "1234");
                    case 6 -> registerPage.inputInvalidCredentials("test", "1234", "test");
                    case 7 -> registerPage.inputInvalidCredentials("practice", "SuperSecretPassword!", "SuperSecretPassword!");
                    default -> throw new IllegalStateException("Unexpected value: " + number);
                };
                Assert.assertEquals(actualResult, expectedResult);
                break;
            } catch (StaleElementReferenceException e) {
                System.err.println("Retries: " + i);
            }
        }
    }

    @Test(dependsOnMethods = "testInputInvalidCredentials", dataProvider = "validICredentials")
    public void testInputValidCredentials(String expectedResult) {
        RegisterPage registerPage = new RegisterPage(driverContainer);

        String actualResult = registerPage.inputValidCredentials("karimtesttesttestkkkkk","12345aaakk","12345aaakk");

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(driverContainer.get().getCurrentUrl(),LOGIN_PAGE_URL);
    }


    @DataProvider(name = "inputValues")
    public Object[][] values() {
        return new Object[][] {
                {""},
                {"test"}
        };
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() {
        return new Object[][]{
                {1, SHORT_USERNAME},
                {2, SHORT_PASSWORD},
                {3, SHORT_PASSWORD},
                {4, WRONG_USERNAME},
                {5, WRONG_USERNAME},
                {6, DIFFERENT_PASSWORDS},
                {7, SAME_CREDS}
        };
    }

    @DataProvider(name = "validICredentials")
    public Object[][] validCredentials() {
      return new Object[][] {
              {VALID_CREDS}
      };
    }



}
