package ru.mtsbank.hm.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.HomePage;
import ru.mtsbank.hm.pages.OTPPage;
import ru.mtsbank.hm.pages.SecurePage;

import java.util.Arrays;

public class OTPTest extends BaseTest {


    @Test
    public void testOpenOTPPage() {
        HomePage homePage = new HomePage(driverContainer);
        OTPPage otpPage = homePage.openOTPPageWithUrl();

        boolean isFooterTrue = false;

        for (String i : FOOTER) {
            if (otpPage.getOTPPageFooter().contains(i)) {
                isFooterTrue = true;
            }
        }

        boolean isTextInfoTrue = false;

        for (String i : OTP_PAGE_TEXT_INFO) {
            if (otpPage.getShowOTPPageTextInfo().contains(i)) {
                isTextInfoTrue = true;
            }
        }

        Assert.assertEquals(homePage.getOTPPageUrl(), OTP_PAGE_URL);
        Assert.assertTrue(otpPage.getOTPPageHeader());
        Assert.assertTrue(isFooterTrue);
        Assert.assertTrue(isTextInfoTrue);
        Assert.assertEquals(otpPage.getShowBackButtonToHomePage(), BACK_BUTTON);
        Assert.assertEquals(otpPage.getEmailFieldName(), EMAIL_FIELD);
        Assert.assertTrue(otpPage.getEmailField());
        Assert.assertEquals(otpPage.getSendOtpButtonText(), OTP_BUTTON_TEXT);
    }

    @Test(dependsOnMethods = "testOpenOTPPage", dataProvider = "invalid email values")
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
        OTPPage otpPage = homePage.openOTPPageWithUrl();
        SecurePage securePage = new SecurePage(driverContainer);

        otpPage.otpLogin(value,code);

        Assert.assertEquals(securePage.getAlert(), OTP_SUCCESS_ALERT);
        Assert.assertEquals(securePage.getSecureUrl(), SECURE_URL);

        boolean isTrue = false;

        for (String i : SECURE_PAGE_TEXT) {
            if (securePage.getSecurePageTextInfo().contains(i)) {
                isTrue = true;
            }
        }
        Assert.assertTrue(isTrue);
        Assert.assertEquals(securePage.getLogoutButtonText(), LOGOUT_BUTTON_SP);
        Assert.assertTrue(securePage.isLogoutButtonInteractable());
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
