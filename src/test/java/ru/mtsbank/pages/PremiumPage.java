package ru.mtsbank.pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PremiumPage extends BasePage{

    public PremiumPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }


    public PremiumPage openPremiumLevelPage() {
        WebDriverWait levelPageWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        levelPageWait.until(ExpectedConditions.visibilityOf(openLevelPage)).click();

        return new PremiumPage(driverContainer);
    }


    public void openPremiumCashbackCategoriesList() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(openPremiumCashbackCategoriesList)).click();
    }


    public void openPremiumCashbackPrivilege() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(openPremiumCashbackPrivilege)).click();
    }





    @FindBy(xpath = "//a[@href='/premium/level']")
    private WebElement openLevelPage;

    @FindBy(xpath = "//a[@href='/premium/cashback-category?fromDate=2025-08-01']")
    private WebElement openPremiumCashbackCategoriesList;

    @FindBy(xpath = "//a[@href='/premium/cashback']")
    private WebElement openPremiumCashbackPrivilege;

    @FindBy(xpath = "//span[contains(text(), 'Премиум') or contains(text(), 'Private')]")
    private WebElement openPremiumPage;

    @FindBy(xpath = "//div[@data-testid='flexbox']/span[contains(text(), 'Премиум') or contains(text(), 'Private')]" )
    private WebElement checkPremiumWidget;


}
