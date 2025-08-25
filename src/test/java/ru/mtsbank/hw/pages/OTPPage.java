package ru.mtsbank.hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OTPPage extends BasePage {

    public OTPPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }



    public String getOTPPageUrl() {
        return driverContainer.get().getCurrentUrl();
    }


    public HomePage clickBackButtonToHomePageFromOTPPage() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
        return new HomePage(driverContainer);
    }

    public boolean getOTPPageHeader() {
        return otpPageHeader.isDisplayed();
    }

    public List<String> getOTPPageFooter() {
        return Collections.singletonList(Arrays.asList(otpPageFooterOne.getText(), otpPageFooterTwo.getText()).toString());
    }

    public String getShowBackButtonToHomePage() {
        return backButton.getText();
    }

    public List<String> getShowOTPPageTextInfo() {
        return Collections.singletonList(Arrays.asList(pageTextCardHeaderName.getText(), pageTextInfo.getText()).toString());
    }

    public String getEmailFieldName() {
        return emailFieldName.getText();
    }

    public boolean getEmailField() {
        emailField.isEnabled();
        return true;
    }

    public String getSendOtpButtonText() {
        return sendOtpButton.getText();
    }

    public String getErrorText() {
        return errorText.getText();
    }

    public String getOtpVerifyHeader() {
        return otpVerifyHeader.getText();
    }

    public String getOtpVerifyMessage() {
        return otpMessage.getText();
    }

    public void inputEmail(String value) {
        emailField.sendKeys(value);
        sendOtpButton.click();
    }

    public void inputOtpCode(String value) {
        otpField.sendKeys(value);
        sendVerifyButton.click();
    }

    public SecurePage otpLogin(String email, String code) {
        inputEmail(email);
        inputOtpCode(code);
        return new SecurePage(driverContainer);
    }

    public String getAlert() {
        return alert.getText();
    }

    public void clearEmailField() {
        emailField.clear();
    }

    public void clearCodeField() {
        otpField.clear();
    }

    public void navigateBack() {
        driverContainer.get().navigate().back();
    }




    @FindBy(xpath = "//a[@href='/'][contains(text(),'Home')]")
    private WebElement backButton;

    @FindBy(xpath = "//header[@class='navbar navbar-expand-md navbar-dark sticky-top main-navbar']")
    private WebElement otpPageHeader;

    @FindBy(xpath = "//div[@class='border-top border-2']")
    private WebElement otpPageFooterOne;

    @FindBy(xpath = "//p[@data-testid='build-version']")
    private WebElement otpPageFooterTwo;

    @FindBy(xpath = "//h1[contains(text(),'OTP Login page for Automation Testing Practice')]")
    private WebElement pageTextCardHeaderName;

    @FindBy(xpath = "//p[contains(text(),'If you d')]")
    private WebElement pageTextInfo;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailFieldName;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@id='btn-send-otp']")
    private WebElement sendOtpButton;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    private WebElement errorText;

    @FindBy(xpath = "//h1[contains(text(),'OTP Verification')]")
    private WebElement otpVerifyHeader;

    @FindBy(xpath = "//p[@id='otp-message']")
    private WebElement otpMessage;

    @FindBy(xpath = "//input[@id='otp']")
    private WebElement otpField;

    @FindBy(xpath = "//button[@id='btn-send-verify']")
    private WebElement sendVerifyButton;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement alert;

}
