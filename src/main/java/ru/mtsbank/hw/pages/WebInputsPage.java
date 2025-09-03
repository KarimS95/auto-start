package ru.mtsbank.hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebInputsPage extends BasePage {
    public WebInputsPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public String getWebInputsPageURL() {
        return driverContainer.get().getCurrentUrl();
    }

    public HomePage clickBackButtonToHomePageFromWebInputsPage() {
        backButton.click();
        return new HomePage(driverContainer);
    }

    public String getWebInputsPageCardHeader() {
        return webInputsPageCardHeader.getText();
    }

    public String getWebInputsPageCardText() {
        return webInputsPageCardText.getText();
    }

    public String getWebInputsPageDisplayInputsButtonName() {
        return displayInputsButton.getText();
    }

    public void clickOnDisplayInputsButton() {
        checkElement(displayInputsButton);
        displayInputsButton.click();
    }

    public String getWebInputsPageClearInputsButtonName() {
        return clearInputsButton.getText();
    }

    public boolean checkDisplayInputsButton() {
        return displayInputsButton.isDisplayed() && displayInputsButton.isEnabled();
    }

    public boolean checkClearInputsButton() {
        return clearInputsButton.isDisplayed() && clearInputsButton.isEnabled();
    }

    public String getInputNumberFieldName() {
        return inputNumberFieldName.getText();
    }

    public boolean checkInputNumberField() {
        return inputNumberField.isDisplayed() && inputNumberField.isEnabled();
    }

    public String getInputTextFieldName() {
        return inputTextFieldName.getText();
    }

    public boolean checkInputTextField() {
        return inputTextField.isDisplayed() && inputTextField.isEnabled();
    }

    public String getInputPasswordFieldName() {
        return inputPasswordFieldName.getText();
    }

    public boolean checkInputPasswordField() {
        return inputPasswordField.isDisplayed() && inputPasswordField.isEnabled();
    }

    public String getInputDateFieldName() {
        return inputDateFieldName.getText();
    }

    public boolean checkInputDateField() {
        return inputDateField.isDisplayed() && inputDateField.isEnabled();
    }

    public String getOutputNumberFieldName() {
        return outputNumberFieldName.getText();
    }

    public boolean checkOutputNumberField() {
        return outputNumberField.isDisplayed() && outputNumberField.isEnabled();
    }

    public String getOutputTextFieldName() {
        return outputTextFieldName.getText();
    }

    public boolean checkOutputTextField() {
        return outputTextField.isDisplayed() && outputTextField.isEnabled();
    }

    public String getOutputPasswordFieldName() {
        return outputPasswordFieldName.getText();
    }

    public boolean checkOutputPasswordField() {
        return outputPasswordField.isDisplayed() && outputPasswordField.isEnabled();
    }

    public String getOutputDateFieldName() {
        return outputDateFieldName.getText();
    }

    public boolean checkOutputDateField() {
        return outputDateField.isDisplayed() && outputDateField.isEnabled();
    }

    public String getWebInputsPageFooter() {
        return webInputsPageFooter.getText();
    }






















    @FindBy(xpath = "//a[@href='/'][text()='Home']")
    private WebElement backButton;

    @FindBy(xpath = "//h1[text()='Web inputs page for Automation Testing Practice']")
    private WebElement webInputsPageCardHeader;

    @FindBy(xpath = "//div[@class='row mt-3']/p[1]")
    private WebElement webInputsPageCardText;

    @FindBy(xpath = "//button[@id='btn-display-inputs']")
    private WebElement displayInputsButton;

    @FindBy(xpath = "//button[@id='btn-clear-inputs']")
    private WebElement clearInputsButton;

    @FindBy(xpath = "//label[@for='input-number']")
    private WebElement inputNumberFieldName;

    @FindBy(xpath = "//input[@name='input-number']")
    private WebElement inputNumberField;

    @FindBy(xpath = "//label[@for='input-text']")
    private WebElement inputTextFieldName;

    @FindBy(xpath = "//input[@name='input-text']")
    private WebElement inputTextField;

    @FindBy(xpath = "//label[@for='input-password']")
    private WebElement inputPasswordFieldName;

    @FindBy(xpath = "//input[@name='input-password']")
    private WebElement inputPasswordField;

    @FindBy(xpath = "//label[@for='input-date']")
    private WebElement inputDateFieldName;

    @FindBy(xpath = "//input[@name='input-date']")
    private WebElement inputDateField;

    @FindBy(xpath = "//label[@for='output-number']")
    private WebElement outputNumberFieldName;

    @FindBy(xpath = "//strong[@id='output-number']")
    private WebElement outputNumberField;

    @FindBy(xpath = "//label[@for='output-text']")
    private WebElement outputTextFieldName;

    @FindBy(xpath = "//strong[@id='output-text']")
    private WebElement outputTextField;

    @FindBy(xpath = "//label[@for='output-password']")
    private WebElement outputPasswordFieldName;

    @FindBy(xpath = "//strong[@id='output-password']")
    private WebElement outputPasswordField;

    @FindBy(xpath = "//label[@for='output-date']")
    private WebElement outputDateFieldName;

    @FindBy(xpath = "//strong[@id='output-date']")
    private WebElement outputDateField;

    @FindBy(xpath = "//h4")
    private WebElement webInputsPageFooter;

}
