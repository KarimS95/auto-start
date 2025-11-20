package ru.mtsbank.likecoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CodePage extends BasePage {

    public CodePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    @FindBy(xpath = "//*[@id = 'otp']")
    private WebElement codeInput;

    @FindBy(xpath = "//*[contains(text(), 'Сервис')]")
    private WebElement errorLabel;

    public HomePage inputCode(List<String> codeList) {
        for (String i : codeList) {
            codeInput.sendKeys(i);
        }
        return new HomePage(driverContainer);
    }

    public String getErrorLabelText() {
        return errorLabel.getText();
    }

    public boolean checkErrorLabel() {
        return errorLabel.isDisplayed();
    }
}
