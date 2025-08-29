package ru.mtsbank.premium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;


public class BasePage {

    protected InheritableThreadLocal<WebDriver> driverContainer;

    public BasePage(InheritableThreadLocal<WebDriver> driverContainer) {
        this.driverContainer = driverContainer;
        PageFactory.initElements(this.driverContainer.get(), this);
    }

//    public <P extends BasePage> P returnToPreviousPage(Class<P> expectedPage) {
//        P page;
//
//        WebDriverWait backButtonWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
//        backButtonWait.until(ExpectedConditions.visibilityOf(backButton)).click();
//
//        try {
//            Constructor<P> constructor = expectedPage.getConstructor(WebDriver.class);
//            page = constructor.newInstance(driverContainer.get());
//        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//        return page;
//    }

    protected void checkElementOnPage(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void returnBack() {
        WebDriverWait backButtonWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        backButtonWait.until(ExpectedConditions.visibilityOf(backButton)).click();
    }


    @FindBy(xpath = "//button[@data-testid='back-button']")//ok
    private WebElement backButton;

    protected static final int MAX_RETRIES = 3;


}