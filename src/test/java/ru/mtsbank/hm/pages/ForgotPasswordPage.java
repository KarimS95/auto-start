package ru.mtsbank.hm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public HomePage clickBackButtonToHomePageFromForgotPasswordPage() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(backButtonClick)).click();
        return new HomePage(driverContainer);
    }

    public String getForgotPasswordPageUrl() {
        return driverContainer.get().getCurrentUrl();
    }

    public boolean getForgotPasswordPageHeader() {
        return forgotPasswordPageHeader.isDisplayed();
    }

    public List<String> getForgotPasswordPageFooter() {
        return Collections.singletonList(Arrays.asList(forgotPasswordPageFooterOne.getText(), forgotPasswordPageFooterTwo.getText()).toString());
    }

    public String getShowBackButtonToHomePage() {
        return backButton.getText();
    }

    public List<String> getShowForgotPasswordPageTextInfo() {
        return Collections.singletonList(Arrays.asList(pageTextHeaderName.getText(), pageTextInfo.getText()).toString());
    }

    public String getEmailFieldName() {
        return emailFieldName.getText();
    }

    public boolean checkEmailField() {
        return emailField.isDisplayed() && emailField.isEnabled();
    }

    public String getRetrievePasswordButtonName() {
        return retrievePasswordButton.getText();
    }

    public boolean checkRetrievePasswordButton() {
        return retrievePasswordButton.isDisplayed() && retrievePasswordButton.isEnabled();
    }

    public void inputEmail(String value) {
        emailField.sendKeys(value);
    }

    public void clickRetrievePasswordButton() {
        retrievePasswordButton.click();
    }

    public void clearField() {
        emailField.clear();
    }

   public String getAlert() {
        return alertMessage.getText();
   }

   public String getErrorMessage() {
        return errorText.getText();
   }

   public String getMessageAfterSuccessfulRetrievePassword() {
        return textAfterSuccessfulRetrievePassword.getText();
   }





    @FindBy(xpath = "//a[@href='/forgot-password'][contains(text(),'Forgot Password Form')]")
    private WebElement forgotPasswordPageLink;

    @FindBy(xpath = "//header[@class='navbar navbar-expand-md navbar-dark sticky-top main-navbar']")
    private WebElement forgotPasswordPageHeader;

    @FindBy(xpath = "//div[@class='border-top border-2']")
    private WebElement forgotPasswordPageFooterOne;

    @FindBy(xpath = "//p[@data-testid='build-version']")
    private WebElement forgotPasswordPageFooterTwo;

    @FindBy(xpath = "//a[text()='Home']")
    private WebElement backButton;

    @FindBy(xpath = "//h1[contains(text(),'Dummy Forgot Password form page for Automation Testing Practice')]")
    private WebElement pageTextHeaderName;

    @FindBy(xpath = "//p[contains(text(), 'Example can be used for practicing the Forgot Password scenario in automated tests. An email will be sent to indicate password reset instructions')]")
    private WebElement pageTextInfo;

    @FindBy(xpath = "//label[@for='email']")
    private WebElement emailFieldName;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement retrievePasswordButton;

    @FindBy(xpath = "//div[@role='alert']")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[contains(text(), 'Please enter a valid email address')]")
    private WebElement errorText;

    @FindBy(xpath = "//h1[contains(text(),'Password reset page for Automation Testing Practice')]")
    private WebElement textAfterSuccessfulRetrievePassword;


}
