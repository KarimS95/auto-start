package ru.mtsbank.hm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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


    //For LoginPage

    public String getLoginPageLinkName() {
        return loginPageLinkLocator.getText();
    }

    public String getLoginPageButtonName() {
        return loginPageButtonLocator.getText();
    }

    public String getLoginPageCardText() {
        return homePageLoginPagesCardText.getText();
    }

    public boolean isLoginPageLinkInteractive() {
        return loginPageLinkLocator.isDisplayed() && loginPageLinkLocator.isEnabled();
    }

    public boolean isLoginPageButtonInteractive() {
        return loginPageButtonLocator.isDisplayed() && loginPageButtonLocator.isEnabled();
    }

    public LoginPage openLoginPageWithClickOnLink() {
        loginPageLinkLocator.click();
        return new LoginPage(driverContainer);
    }

    public LoginPage openLoginPageWithClickOnButton() {
        loginPageButtonLocator.click();
        return new LoginPage(driverContainer);
    }



    //For RegisterPage

    public boolean isRegisterPageLinkInteractive() {
       return registerPageLinkLocator.isDisplayed() && registerPageLinkLocator.isEnabled();
    }

    public String getRegisterPageCardText() {
        return registerPageCardTextLocator.getText();
    }

    public boolean isRegisterPageButtonInteractive() {
       return registerPageButtonLocator.isDisplayed() && registerPageButtonLocator.isEnabled();
    }

    public String getRegisterPageButtonText() {
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


    public boolean isForgotPasswordPageLinkInteractive() {
        return forgotPasswordPageLinkLocator.isDisplayed() && forgotPasswordPageLinkLocator.isEnabled();
    }

    public String getForgotPasswordPageCardText() {
        WebDriverWait waitForgotPasswordPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitForgotPasswordPageLinkLocator.until(ExpectedConditions.visibilityOf(forgotPasswordPageCardTextLocator));
        return forgotPasswordPageCardTextLocator.getText();
    }

    public boolean isForgotPasswordPageButtonInteractive() {
        return forgotPasswordPageButtonLocator.isDisplayed() && forgotPasswordPageButtonLocator.isEnabled();
    }

    public String getForgotPasswordPageButtonText() {
        return forgotPasswordPageButtonLocator.getText();
    }

    public ForgotPasswordPage openForgotPasswordPageWithClickOnLink() {
        WebDriverWait waitForgotPasswordPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitForgotPasswordPageLinkLocator.until(ExpectedConditions.elementToBeClickable(forgotPasswordPageLinkLocator)).click();
        return new ForgotPasswordPage(driverContainer);
    }

    public ForgotPasswordPage openForgotPasswordPageWithClickOnButton() {
        WebDriverWait waitForgotPasswordPageLinkLocator = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitForgotPasswordPageLinkLocator.until(ExpectedConditions.elementToBeClickable(forgotPasswordPageLinkLocator)).click();
        return new ForgotPasswordPage(driverContainer);
    }


    //For OTPPage

    public OTPPage openOTPPageWithUrl(String url) {
        driverContainer.get().get(url);
        return new OTPPage(driverContainer);
    }

    public boolean isOTPPageLinkInteractive() {
        return otpPageLinkLocator.isDisplayed() && otpPageLinkLocator.isEnabled();
    }

    public String getOTPPageCardText() {
        return otpPageCardTextLocator.getText();
    }

    public boolean isOtpPageButtonInteractive() {
        return otpPageButtonLocator.isDisplayed() && otpPageButtonLocator.isEnabled();
    }

    public String getOTPPageButtonText() {
        return otpPageButtonLocator.getText();
    }

    public OTPPage openOTPPageWithClickOnLink() {
       WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
       wait.until(ExpectedConditions.elementToBeClickable(otpPageLinkLocator));

       ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].scrollIntoView(true);",otpPageLinkLocator);
       otpPageLinkLocator.click();
       return new OTPPage(driverContainer);
    }

    public OTPPage openOTPPageWithClickOnButton() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(otpPageButtonLocator));

        otpPageButtonLocator.sendKeys(Keys.PAGE_DOWN);
        otpPageButtonLocator.click();

        return new OTPPage(driverContainer);
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




    @FindBy(xpath = "//a[@href='/otp-login'][text()='OTP: One Time Password']")
    private WebElement otpPageLinkLocator;

    @FindBy(xpath = "//p[contains(text(),'The example of a One Time Password (OTP) illustrates the process of authentication using an OTP code')]")
    private WebElement otpPageCardTextLocator;

    @FindBy(xpath = "//a[@type='button'][@href='/otp-login'][text()='Try it out']")
    private WebElement otpPageButtonLocator;

    @FindBy(xpath = "//a[@href='/login'][text()='Test Login Page']")
    private WebElement loginPageLinkLocator;

    @FindBy(xpath = "//a[@type='button'][@href='/login']")
    private WebElement loginPageButtonLocator;

    @FindBy(xpath = "//p[contains(text(),' Test Login Page for Automation Testing Practice, a common use case for website authentication. You can use Playwright to automate these login test scenarios')]")
    private WebElement homePageLoginPagesCardText;


}
