package ru.mtsbank.hm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }


    public String getLoginPageUrl() {
        return driverContainer.get().getCurrentUrl();
    }



}
