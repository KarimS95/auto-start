package ru.mtsbank.hm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RegisterPage extends BasePage {

    public RegisterPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public String getRegisterPageUrl() {
        return driverContainer.get().getCurrentUrl();
    }

    public boolean getRegisterPageHeader() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(registerPageHeader));
        return true;
    }

    public List<String> getRegisterPageFooter() {
        return Collections.singletonList(Arrays.asList(registerPageFooterOne.getText(), registerPageFooterTwo.getText()).toString());
    }

    public String getShowBackButtonToHomePage() {
        return backButton.getText();
    }

    public HomePage clickBackButtonToHomePageFromRegisterPage() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(backButtonClick)).click();
        return new HomePage(driverContainer);
    }

    public List<String> getShowRegisterPageTextInfo() {
        return Collections.singletonList(Arrays.asList(pageTextHeaderName.getText(),pageTextInfo.getText()).toString());
    }

    public String getUsernameFieldName() {
        return userNameFieldName.getText();
    }

    public boolean checkUsernameField() {
        return userNameField.isEnabled();
    }

    public String getPasswordFieldName() {
        return passwordFieldName.getText();
    }

    public boolean checkPasswordField() {
        return passwordField.isEnabled();
    }

    public String checkConfirmPasswordFieldName() {
        return confirmPasswordFieldName.getText();
    }

    public boolean checkConfirmPasswordField() {
        return confirmPasswordField.isEnabled();
    }

    public String checkRegisterButtonName() {
        return registerButton.getText();
    }

    public String inputUsername(String value) {
        userNameField.sendKeys(value);
        registerButton.click();
        return alertMessage.getText();
    }

    public String inputPassword(String value) {
        passwordField.sendKeys(value);
        registerButton.click();
        return alertMessage.getText();
    }

    public String inputConfirmPassword(String value) {
        confirmPasswordField.sendKeys(value);
        registerButton.click();
        return alertMessage.getText();
    }

    public String inputInvalidCredentials(String username, String password, String confirmPassword) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        registerButton.click();
        return alertMessage.getText();
    }

//    public LoginPage inputValidCredentials(String username, String password, String confirmPassword) {
//        userNameField.sendKeys(username);
//        passwordField.sendKeys(password);
//        confirmPasswordField.sendKeys(confirmPassword);
//        registerButton.click();
//
//        return new LoginPage(driverContainer);
//    }

    public String inputValidCredentials(String username, String password, String confirmPassword) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        registerButton.click();

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(alertMessage));

        return alertMessage.getText();
    }

    public void registerButtonClick() {
        registerButton.click();
    }



    @FindBy(xpath = "//header[@class='navbar navbar-expand-md navbar-dark sticky-top main-navbar']")
    private WebElement registerPageHeader;

    @FindBy(xpath = "//div[@class='border-top border-2']")
    private WebElement registerPageFooterOne;

    @FindBy(xpath = "//p[@data-testid='build-version']")
    private WebElement registerPageFooterTwo;

    @FindBy(xpath = "//a[text()='Home']")
    private WebElement backButton;

    @FindBy(xpath = "//a[@href='/']")
    private WebElement backButtonClick;

    @FindBy(xpath = "//h1[contains(text(),'Register page for Automation Testing Practice')]")
    private WebElement pageTextHeaderName;

    @FindBy(xpath = "//div[@class='col-9']")
    private WebElement pageTextInfo;

    @FindBy(xpath = "//label[@for='username']")
    private WebElement userNameFieldName;

    @FindBy(id = "username")
    private WebElement userNameField;

    @FindBy(xpath = "//label[@for='password']")
    private WebElement passwordFieldName;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//label[@for='confirmPassword']")
    private WebElement confirmPasswordFieldName;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[contains(text(),'Register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement alertMessage;

}
