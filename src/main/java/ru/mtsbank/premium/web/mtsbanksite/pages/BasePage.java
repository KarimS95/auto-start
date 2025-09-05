package ru.mtsbank.premium.web.mtsbanksite.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected InheritableThreadLocal<WebDriver> driverContainer;

    public BasePage(InheritableThreadLocal<WebDriver> driverContainer) {
        this.driverContainer = driverContainer;
        PageFactory.initElements(this.driverContainer.get(), this);
    }



    protected WebDriverWait waitElement() {
        return new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
    }

    protected void js(String value, WebElement element) {
        ((JavascriptExecutor)driverContainer.get()).executeScript(value, element);
    }

}
