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

        Assert.assertEquals(forgotPasswordPage.getForgotPasswordPageUrl(), FORGOT_PASSWORD_PAGE_URL);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenForgotPasswordPage")
    public void testGetForgotPasswordPageHeader() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        Assert.assertTrue(forgotPasswordPage.getForgotPasswordPageHeader());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenForgotPasswordPage")
    public void testGetForgotPasswordPageFooter() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        boolean footerIsTrue = false;
        for (String i : FOOTER) {
            if (forgotPasswordPage.getForgotPasswordPageFooter().contains(i)) {
                footerIsTrue = true;
            }
        }
        Assert.assertTrue(footerIsTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenForgotPasswordPage")
    public void testGetShowForgotPasswordPageTextInfo() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        boolean textInfoIsTrue = false;
        for (String i : FORGOT_PASSWORD_PAGE_TEXT_INFO) {
            if (forgotPasswordPage.getShowForgotPasswordPageTextInfo().contains(i)) {
                textInfoIsTrue = true;
            }
        }
        Assert.assertTrue(textInfoIsTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenForgotPasswordPage")
    public void testGetShowBackButtonToHomePage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        Assert.assertEquals(forgotPasswordPage.getShowBackButtonToHomePage(), BACK_BUTTON);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenForgotPasswordPage")
    public void testGetEmailFieldName() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        Assert.assertEquals(forgotPasswordPage.getEmailFieldName(), EMAIL_FIELD_FP);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenForgotPasswordPage")
    public void testCheckEmailField() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        Assert.assertTrue(forgotPasswordPage.checkEmailField());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenForgotPasswordPage")
    public void testGetRetrievePasswordButtonName() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        Assert.assertEquals(forgotPasswordPage.getRetrievePasswordButtonName(), RETRIEVE_PASSWORD_BUTTON);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenForgotPasswordPage")
    public void testCheckRetrievePasswordButton() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        Assert.assertTrue(forgotPasswordPage.checkRetrievePasswordButton());
    }

    @Test(dependsOnGroups = "parallel", dataProvider = "emails")
    public void testInputEmail(int number, String value) {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverContainer);

        boolean isTrue = false;

        switch (number) {
            case 1 -> {
                forgotPasswordPage.inputEmail(value);
                forgotPasswordPage.clickRetrievePasswordButton();

                for (String i : INVALID_EMAIL) {
                    if (forgotPasswordPage.getErrorMessage().contains(i)) {
                        isTrue = true;
                        forgotPasswordPage.clearField();
                    }
                }
                Assert.assertTrue(isTrue);
            }
            case 2 -> {
                forgotPasswordPage.inputEmail(value);
                forgotPasswordPage.clickRetrievePasswordButton();

                for (String i : INVALID_EMAIL) {
                    if (forgotPasswordPage.getAlert().contains(i)) {
                        isTrue = true;
                        forgotPasswordPage.clearField();
                    }
                }
                Assert.assertTrue(isTrue);
            }
            case 3 -> {
                forgotPasswordPage.inputEmail(value);
                forgotPasswordPage.clickRetrievePasswordButton();
                for (String i : VALID_EMAIL) {
                    if (forgotPasswordPage.getAlert().contains(i)) {
                        isTrue = true;
                    }
                }
                Assert.assertEquals(forgotPasswordPage.getMessageAfterSuccessfulRetrievePassword(), MESSAGE_AFTER_PASSWORD_RETRIEVE);
            }
        }
        Assert.assertTrue(isTrue);
    }

    @DataProvider(name = "emails")
    public Object[][] emails() {
        return new Object[][]{
                {1, "@test"},
                {2, "test@test"},
                {3, "karimssss412125240221@gmail.com"}
        };
    }


}
