package ru.mtsbank.premium.web.mtsmoney.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CodePage extends BasePage {

    public CodePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public HomePage inputCode(String[] passwordList) {

        for (String i : passwordList) {
            inputCode.sendKeys(i);
        }
        return new HomePage(driverContainer);
    }


    @FindBy(xpath = "//input[@id='otp']")
    private WebElement inputCode;

}
