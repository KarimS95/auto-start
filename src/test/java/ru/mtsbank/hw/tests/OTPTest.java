package ru.mtsbank.hw.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.hw.pages.HomePage;
import ru.mtsbank.hw.pages.OTPPage;
import ru.mtsbank.hw.pages.SecurePage;

public class OTPTest extends BaseTest {


    @Test
    public void testOpenOTPPage() {
        HomePage homePage = new HomePage(driverContainer);
        OTPPage otpPage = homePage.openOTPPageWithClickOnLink();

        Assert.assertEquals(otpPage.getOTPPageUrl(), OTP_PAGE_URL);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenOTPPage")
    public void testGetOTPPageHeader() {
        OTPPage otpPage = new OTPPage(driverContainer);

        Assert.assertTrue(otpPage.getOTPPageHeader());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenOTPPage")
    public void testGetShowBackButtonToHomePage() {
        OTPPage otpPage = new OTPPage(driverContainer);

        Assert.assertEquals(otpPage.getShowBackButtonToHomePage(), BACK_BUTTON);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenOTPPage")
    public void testGetEmailFieldName() {
        OTPPage otpPage = new OTPPage(driverContainer);

        Assert.assertEquals(otpPage.getEmailFieldName(), EMAIL_FIELD);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenOTPPage")
    public void testGetEmailField() {
        OTPPage otpPage = new OTPPage(driverContainer);

        Assert.assertTrue(otpPage.getEmailField());
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenOTPPage")
    public void testGetSendOtpButtonText() {
        OTPPage otpPage = new OTPPage(driverContainer);

        Assert.assertEquals(otpPage.getSendOtpButtonText(), OTP_BUTTON_TEXT);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenOTPPage")
    public void testGetOTPPageFooter() {
        OTPPage otpPage = new OTPPage(driverContainer);

        boolean isFooterTrue = false;

        for (String i : FOOTER) {
            if (otpPage.getOTPPageFooter().contains(i)) {
                isFooterTrue = true;
            }
        }
        Assert.assertTrue(isFooterTrue);
    }

    @Test(groups = "parallel", dependsOnMethods = "testOpenOTPPage")
    public void testGetShowOTPPageTextInfo() {
        OTPPage otpPage = new OTPPage(driverContainer);

        boolean isTextInfoTrue = false;

        for (String i : OTP_PAGE_TEXT_INFO) {
            if (otpPage.getShowOTPPageTextInfo().contains(i)) {
                isTextInfoTrue = true;
            }
        }
        Assert.assertTrue(isTextInfoTrue);
    }

    @Test(dependsOnGroups = "parallel", dataProvider = "invalid email values")
    public void testNegativeOtpLogin(int number, String email) {
        OTPPage otpPage = new OTPPage(driverContainer);

        switch (number) {
            case 1, 2 -> {
                otpPage.inputEmail(email);
                Assert.assertEquals(otpPage.getErrorText(), INVALID_EMAIL_OTP);
            }
            case 3 -> {
                otpPage.clearEmailField();
                otpPage.inputEmail(email);
                Assert.assertEquals(otpPage.getOtpVerifyHeader(), OTP_VERIFY_HEADER);
                Assert.assertEquals(otpPage.getOtpVerifyMessage(), SUCCESS_EMAIL_ALERT);
                otpPage.inputOtpCode("12345");
                Assert.assertEquals(otpPage.getOtpVerifyMessage(), INVALID_OTP_CODE);
            }
        }
    }

    @Test(dependsOnMethods = "testNegativeOtpLogin", dataProvider = "otpValues")
    public void testPositiveOtpLogin(String value, String code) {
        HomePage homePage = new HomePage(driverContainer);
        OTPPage otpPage = homePage.openOTPPageWithUrl(OTP_PAGE_URL);
        SecurePage securePage = new SecurePage(driverContainer);

        otpPage.otpLogin(value,code);

        Assert.assertEquals(securePage.getAlert(), LOGGED_IN);
        Assert.assertEquals(securePage.getSecurePageUrl(), SECURE_URL);
    }




    @DataProvider(name = "invalid email values")
    public Object[][] invalidEmailValues() {
        return new Object[][] {
                {1,""},
                {2,"@d"},
                {3,"practice@expandtesting.com"}
        };
    }

    @DataProvider(name = "otpValues")
    public Object[][] otpValues() {
        return new Object[][] {
                {"practice@expandtesting.com","214365"}
        };
    }


}
