package ru.mtsbank.hw.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        checkElement(backButtonClick);
        backButtonClick.click();
        return new HomePage(driverContainer);
    }

    public List<String> getShowRegisterPageTextInfo() {
        return Collections.singletonList(Arrays.asList(pageTextHeaderName.getText(),pageTextInfo.getText()).toString());
    }

    public String getUsernameFieldName() {
        return userNameFieldName.getText();
    }

    public boolean checkUsernameField() {
        return userNameField.isDisplayed() && userNameField.isEnabled();
    }

    public String getPasswordFieldName() {
        return passwordFieldName.getText();
    }

    public boolean checkPasswordField() {
        return passwordField.isDisplayed() && passwordField.isEnabled();
    }

    public String checkConfirmPasswordFieldName() {
        return confirmPasswordFieldName.getText();
    }

    public boolean checkConfirmPasswordField() {
        return confirmPasswordField.isDisplayed() && confirmPasswordField.isEnabled();
    }

    public String getRegisterButtonName() {
        return registerButton.getText();
    }

    public boolean isRegistrationButtonInteractive() {
        return registerButton.isDisplayed() && registerButton.isEnabled();
    }

    public void inputUsername(String value) {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(),Duration.ofSeconds(30));
        for (int i = 0; i < 4; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(userNameField));
                ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].focus();",userNameField);
                userNameField.sendKeys(value);
                break;
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                System.out.println("Retries: " + i);
            }
        }
    }

    public void inputPassword(String value) {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(),Duration.ofSeconds(30));
        for (int i = 0; i < 4; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(passwordField));
                ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].focus();",passwordField);
                passwordField.sendKeys(value);
                break;
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                System.out.println("Retries: " + i);
            }
        }
    }

    public void inputConfirmPassword(String value) {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(),Duration.ofSeconds(30));
        for (int i = 0; i < 4; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordField));
                ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].scrollIntoView({block:'center'}); focus();",confirmPasswordField);
                confirmPasswordField.sendKeys(value);
                break;
            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                System.out.println("Retries: " + i);
            }
        }
    }


    public void clickRegisterButton() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].scrollIntoView({block:'center'});",registerButton);
        for (int i = 0; i < 4; i++) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(registerButton));
                registerButton.click();
                break;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                System.out.println("Retries: " + i);
            }
        }
    }

    public String getAlert() {
        return alertMessage.getText();
    }


    public LoginPage registration(String username, String password, String confirmPassword) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        clickRegisterButton();

        return new LoginPage(driverContainer);
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

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameField;

    @FindBy(xpath = "//label[@for='password']")
    private WebElement passwordFieldName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//label[@for='confirmPassword']")
    private WebElement confirmPasswordFieldName;

    @FindBy(xpath = "//input[@id='confirmPassword']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[contains(text(),'Register')]")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement alertMessage;

}
