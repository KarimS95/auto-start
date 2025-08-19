package ru.mtsbank.hm.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    InheritableThreadLocal<WebDriver> driverContainer;

    public BasePage(InheritableThreadLocal<WebDriver> driverContainer) {
        this.driverContainer = driverContainer;
        PageFactory.initElements(driverContainer.get(),this);
    }


    public HomePage clickBackButtonToHomePage() {
        backButtonClick.click();
        return new HomePage(driverContainer);
    }

    protected void checkElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    @FindBy(xpath = "//a[@href='/']")
    protected WebElement backButtonClick;
}
