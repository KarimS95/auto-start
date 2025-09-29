package ru.mtsbank.likeCoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(InheritableThreadLocal<WebDriver> driverContainer){
        super(driverContainer);
    }

    @FindBy(xpath = "//input[@id = 'login' or type = 'tel']")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[text() = 'Далее']/parent::button")
    private WebElement nextButton;


    public CodePage inputLogin(String phoneNumber) {
        inputLogin.sendKeys(phoneNumber);
        nextButton.click();
        return new CodePage(driverContainer);
    }


}
