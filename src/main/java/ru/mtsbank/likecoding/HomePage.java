package ru.mtsbank.likecoding;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    public HomePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }
}
