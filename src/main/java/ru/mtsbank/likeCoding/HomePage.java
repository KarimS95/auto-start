package ru.mtsbank.likeCoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {


    public HomePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }


    @FindBy(xpath = "//*[text()='Премиум' or text()='Private Banking']/parent::div")
    private WebElement premiumPrivateWidget;


    public String getPremiumPrivateWidgetName() {
        return premiumPrivateWidget.getText();
    }

    public boolean checkPremiumPrivateWidget() {
        return premiumPrivateWidget.isEnabled() && premiumPrivateWidget.isDisplayed();
    }

    public String getHomePageUrl() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.urlContains("https://online.mts"));
        return driverContainer.get().getCurrentUrl();
    }

}
