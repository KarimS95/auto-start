package ru.mtsbank.likeCoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    @FindBy(xpath = "//*[text() = 'Премиум' or text() = 'Private Banking']/parent::div")
    private WebElement premiumPrivateWidget;


    public boolean checkPremiumPrivateWidget() {
        return premiumPrivateWidget.isDisplayed() && premiumPrivateWidget.isEnabled();
    }

    public String getPremiumPrivateWidgetName() {
        return premiumPrivateWidget.getText();
    }

    public String getHomePageUrl() {
        waitElement().until(ExpectedConditions.urlContains("https://online.mtsdengi"));
        return driverContainer.get().getCurrentUrl();
    }

}
