package ru.mtsbank.hm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

    public LoginPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }


    public String getLoginPageUrl() {
        return driverContainer.get().getCurrentUrl();
    }

    public String getLoginPageCardHeader() {
        return loginPageCardHeader.getText();
    }

    public String getLoginPageCardText() {
        return loginPageCardText.getText();
    }

    public boolean checkRegisterLink() {
        return registerLink.isDisplayed() && registerLink.isEnabled();
    }

    public String getUsernameFieldName() {
        return usernameFieldName.getText();
    }

    public String getPasswordFieldName() {
        return passwordFieldName.getText();
    }

    public boolean checkUsernameField() {
        return usernameField.isDisplayed() && usernameField.isEnabled();
    }

    public boolean checkPasswordField() {
        return passwordField.isDisplayed() && passwordField.isEnabled();
    }

    public String getLoginButtonText() {
        return loginButton.getText();
    }

    public boolean checkLoginButton() {
        return loginButton.isDisplayed() && loginButton.isEnabled();
    }

    public String alert() {
        return alert.getText();
    }

    public void inputUsername(String value) {
        usernameField.sendKeys(value);
    }

    public void inputPassword(String value) {
        passwordField.sendKeys(value);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public SecurePage login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        return new SecurePage(driverContainer);
    }







    @FindBy(xpath = "//h1[contains(text(),'Login page for Automation Testing Practice')]")
    private WebElement loginPageCardHeader;

    @FindBy(xpath = "//div[@class='col-9']")
    private WebElement loginPageCardText;

    @FindBy(xpath = "//a[@href='/register']")
    private WebElement registerLink;

    @FindBy(xpath = "//label[@for='username']")
    private WebElement usernameFieldName;

    @FindBy(xpath = "//label[@for='password']")
    private WebElement passwordFieldName;

    @FindBy(xpath = "//input[@type='text'][@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@type='password'][@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit'][contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement alert;



}
