package ru.mtsbank.premium.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CodePage extends BasePage {

    private static final String[] URLS = {"https://online.mtsdengi-test.mbrd.ru/", "https://online.mtsdengi-dev.mbrd.ru/"};

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
