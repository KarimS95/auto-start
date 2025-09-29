package ru.mtsbank.likeCoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    InheritableThreadLocal<WebDriver> driverContainer;

    public BasePage(InheritableThreadLocal<WebDriver> driverContainer) {
        this.driverContainer = driverContainer;
        PageFactory.initElements(this.driverContainer.get(), this);
    }


    protected WebDriverWait waitElement() {
        return new WebDriverWait(driverContainer.get(), Duration.ofSeconds(10));
    }

}
