package ru.mtsbank.likecoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    InheritableThreadLocal<WebDriver> driverContainer;

    public BasePage(InheritableThreadLocal<WebDriver> driverContainer) {
        this.driverContainer = driverContainer;
        PageFactory.initElements(this.driverContainer.get(), this);
    }
}
