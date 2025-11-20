package ru.mtsbank.likecoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super (driverContainer);
    }


    @FindBy(xpath = "//input[@id = 'login' or @type = 'tel']")
    private WebElement loginInput;

    @FindBy(xpath = "//*[text() = 'Далее']")
    private WebElement nextButton;


    public CodePage login(String phoneNumber) {
        loginInput.sendKeys(phoneNumber);
        nextButton.click();
        return new CodePage(driverContainer);
    }
}
