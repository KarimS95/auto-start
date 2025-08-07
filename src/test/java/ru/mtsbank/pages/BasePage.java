package ru.mtsbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.List;


public abstract class BasePage {

    protected InheritableThreadLocal<WebDriver> driverContainer;

    public BasePage(InheritableThreadLocal<WebDriver> driverContainer) {
        this.driverContainer = driverContainer;
        PageFactory.initElements(this.driverContainer.get(), this);
    }



    public <P extends BasePage> P returnToPreviousPage(Class<P> expectedPage) {
        P page;

        WebDriverWait backButtonWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        backButtonWait.until(ExpectedConditions.visibilityOf(backButton)).click();

        try {
            Constructor<P> constructor = expectedPage.getConstructor(WebDriver.class);
            page = constructor.newInstance(driverContainer.get());
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return page;
    }


    @FindBy(xpath = "//a[@href='/premium/level']")
    private WebElement openLevelPage;

    @FindBy(xpath = "//a[@href='/premium/cashback-category?fromDate=2025-08-01']")
    private WebElement openPremiumCashbackCategoriesList;

    @FindBy(xpath = "//a[@href='/premium/cashback']")
    private WebElement openPremiumCashbackPrivilege;

    @FindBy(xpath = "//button[@data-testid='back-button']")//ok
    private WebElement backButton;

    @FindBy(xpath = "//span[contains(text(), 'Премиум') or contains(text(), 'Private')]")
    private WebElement openPremiumPage;

    @FindBy(xpath = "//div[@data-testid='flexbox']/span[contains(text(), 'Премиум') or contains(text(), 'Private')]" )
    private WebElement checkPremiumWidget;
}