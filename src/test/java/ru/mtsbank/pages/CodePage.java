package ru.mtsbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CodePage extends BasePage{

    private static final String url = "https://online.mtsdengi-test.mbrd.ru/";

    public CodePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public HomePage inputCode(List<String> passwordList) {

        for(String i: passwordList) {
            inputCode.sendKeys(i);
        }

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.urlToBe(url));

        return new HomePage(driverContainer);
    }


    @FindBy(xpath = "//input[@type='tel']")
    private WebElement inputCode;

}
