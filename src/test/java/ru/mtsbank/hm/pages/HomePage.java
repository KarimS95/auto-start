package ru.mtsbank.hm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }


    public String getHomePageUrl() {
        return driverContainer.get().getCurrentUrl();
    }

    //For RegisterPage

    public boolean isRegisterPageLinkDisplayed() {
        WebDriverWait waitRegisterPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLinkLocator.until(ExpectedConditions.elementToBeClickable(registerPageLinkLocator));
        return true;
    }

    public String getRegisterPageCardText() {
        WebDriverWait waitRegisterPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLinkLocator.until(ExpectedConditions.visibilityOf(registerPageCardTextLocator));
        return registerPageCardTextLocator.getText();
    }

    public boolean isRegisterPageButtonDisplayed() {
        WebDriverWait waitRegisterPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLinkLocator.until(ExpectedConditions.elementToBeClickable(registerPageButtonLocator));
        return true;
    }

    public String getRegisterPageButtonText() {
        WebDriverWait waitRegisterPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLinkLocator.until(ExpectedConditions.visibilityOf(registerPageButtonLocator));
        return registerPageButtonLocator.getText();
    }

    public RegisterPage openRegisterPageWithClickOnLink() {
        WebDriverWait waitRegisterPageLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLocator.until(ExpectedConditions.elementToBeClickable(registerPageLinkLocator)).click();
        return new RegisterPage(driverContainer);
    }

    public RegisterPage openRegisterPageWithClickOnButton() {
        WebDriverWait waitRegisterPageLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLocator.until(ExpectedConditions.elementToBeClickable(registerPageLinkLocator)).click();
        return new RegisterPage(driverContainer);
    }

    //For ForgotPasswordPage


    public boolean isForgotPasswordPageLinkDisplayed() {
        WebDriverWait waitRegisterPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLinkLocator.until(ExpectedConditions.elementToBeClickable(forgotPasswordPageLinkLocator));
        return true;
    }

    public String getForgotPasswordPageCardText() {
        WebDriverWait waitRegisterPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLinkLocator.until(ExpectedConditions.visibilityOf(forgotPasswordPageCardTextLocator));
        return forgotPasswordPageCardTextLocator.getText();
    }

    public boolean isForgotPasswordPageButtonDisplayed() {
        WebDriverWait waitRegisterPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLinkLocator.until(ExpectedConditions.elementToBeClickable(forgotPasswordPageButtonLocator));
        return true;
    }

    public String getForgotPasswordPageButtonText() {
        WebDriverWait waitRegisterPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLinkLocator.until(ExpectedConditions.visibilityOf(forgotPasswordPageButtonLocator));
        return forgotPasswordPageButtonLocator.getText();
    }

    public ForgotPasswordPage openForgotPasswordPageWithClickOnLink() {
        WebDriverWait waitRegisterPageLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLocator.until(ExpectedConditions.elementToBeClickable(forgotPasswordPageLinkLocator)).click();
        return new ForgotPasswordPage(driverContainer);
    }

    public ForgotPasswordPage openForgotPasswordPageWithClickOnButton() {
        WebDriverWait waitRegisterPageLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitRegisterPageLocator.until(ExpectedConditions.elementToBeClickable(forgotPasswordPageLinkLocator)).click();
        return new ForgotPasswordPage(driverContainer);
    }


    //For OTPPage

    public boolean isOTPPageLinkDisplayed() {
        otpPageLinkLocator.isDisplayed();
        return true;
    }





    @FindBy(xpath = "//a[@href='/forgot-password'][text()='Forgot Password Form']")
    WebElement forgotPasswordPageLinkLocator;

    @FindBy(xpath = "//p[contains(text(),'Example can be used for practicing the Forgot Password scenario in automated tests. An email will be sent to indicate password reset instructions')]")
    private WebElement forgotPasswordPageCardTextLocator;

    @FindBy(xpath = "//a[@type='button'][@href='/forgot-password'][text()='Try it out']")
    private WebElement forgotPasswordPageButtonLocator;



    @FindBy(xpath = "//a[@href='/register'][text()='Test Register Page']")
    private WebElement registerPageLinkLocator;

    @FindBy(xpath = "//p[contains(text(),'Test Register Page for Automation Testing Practice, a common use case for website authentication. You can use Playwright to automate these registration test scenarios')]")
    private WebElement registerPageCardTextLocator;

    @FindBy(xpath = "//a[@type='button'][@href='/register'][text()='Try it out']")
    private WebElement registerPageButtonLocator;


    private final String HOME_PAGE_URL = "https://practice.expandtesting.com/";

    @FindBy(xpath = "//a[@href='/otp-login'][contains(text(),'OTP: One Time Password')]")
    private WebElement otpPageLinkLocator;

}
