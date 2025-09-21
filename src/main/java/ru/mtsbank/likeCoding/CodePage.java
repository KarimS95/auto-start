package ru.mtsbank.likeCoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CodePage extends BasePage {

    public CodePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }



    @FindBy(xpath = "//input[@id='otp']")
    private WebElement inputCode;

    public HomePage inputCode(String[] codeList) {
        for (String i : codeList) {
            inputCode.sendKeys(i);
        }
        return new HomePage(driverContainer);
    }

}
