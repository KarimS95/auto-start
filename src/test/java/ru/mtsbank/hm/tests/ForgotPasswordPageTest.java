package ru.mtsbank.hm.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.ForgotPasswordPage;
import ru.mtsbank.hm.pages.HomePage;


public class ForgotPasswordPageTest extends BaseTest {


    @Test
    public void testOpenForgotPasswordPage() {
        HomePage homePage = new HomePage(driverContainer);
        ForgotPasswordPage forgotPasswordPage = homePage.openForgotPasswordPageWithClickOnButton();

        boolean footerIsTrue = false;
        for (String i : FOOTER) {
            if (forgotPasswordPage.getForgotPasswordPageFooter().contains(i)) {
                footerIsTrue = true;
            }
        }
        boolean textInfoIsTrue = false;
        for (String i : FORGOT_PASSWORD_PAGE_TEXT_INFO) {
            if (forgotPasswordPage.getShowForgotPasswordPageTextInfo().contains(i)) {
                textInfoIsTrue = true;
            }
        }

        Assert.assertEquals(forgotPasswordPage.getForgotPasswordPageUrl(), FORGOT_PASSWORD_PAGE_URL);
        Assert.assertTrue(forgotPasswordPage.getForgotPasswordPageHeader());
        Assert.assertTrue(footerIsTrue);
        Assert.assertTrue(textInfoIsTrue);
        Assert.assertEquals(forgotPasswordPage.getShowBackButtonToHomePage(), BACK_BUTTON);
    }

    @Test(dependsOnMethods = "testOpenForgotPasswordPage")
    public void testCheckEmailField() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        Assert.assertEquals(forgotPasswordPage.getEmailFieldName(), EMAIL_FIELD_FP);
        Assert.assertTrue(forgotPasswordPage.getEmailField());
    }

    @Test(dependsOnMethods = "testCheckEmailField")
    public void testRetrievePasswordButton() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        Assert.assertEquals(forgotPasswordPage.getRetrievePasswordButtonName(), RETRIEVE_PASSWORD_BUTTON);
        Assert.assertTrue(forgotPasswordPage.getRetrievePasswordButton());
    }


    @Test(dependsOnMethods = "testRetrievePasswordButton", dataProvider = "alerts")
    public void testInputEmail(int number, String value) {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        boolean isTrue = false;

        switch (number) {
            case 1 -> {
                forgotPasswordPage.inputEmail(value);

                for (String i : INVALID_EMAIL) {
                    if (forgotPasswordPage.getTextMessage().contains(i)) {
                        isTrue = true;
                        forgotPasswordPage.clearField();
                    }
                }
            }
            case 2 -> {
                forgotPasswordPage.inputEmail(value);

                for (String i : INVALID_EMAIL) {
                    if (forgotPasswordPage.getAlertMessage().contains(i)) {
                        isTrue = true;
                        forgotPasswordPage.clearField();
                    }
                }
            }
            case 3 -> {
                forgotPasswordPage.inputEmail(value);
                for (String i : VALID_EMAIL) {
                    if (forgotPasswordPage.getAlertMessage().contains(i)) {
                        isTrue = true;
                        Assert.assertEquals(forgotPasswordPage.getMessageAfterSuccessfulRetrievePassword(), MESSAGE_AFTER_PASSWORD_RETRIEVE);
                    }
                }
            }
        }
        Assert.assertTrue(isTrue);
    }

    @DataProvider(name = "alerts")
    public Object[][] alerts() {
        return new Object[][]{
                {1, "@test"},
                {2, "test@test"},
                {3, "karimssss412125240221@gmail.com"}
        };
    }


}
