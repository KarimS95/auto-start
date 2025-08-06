package ru.mtsbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CodePage extends BasePage{

    public CodePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public void inputCode(List<String> passwordList) {
        for(String i: passwordList) {
            inputCode.sendKeys(i);
        }
    }


    @FindBy(xpath = "//input[@type='tel']")
    private WebElement inputCode;

}
