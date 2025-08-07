package ru.mtsbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public PremiumPage openPremiumPage() {
        WebDriverWait openPremiumPageWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(200));
        openPremiumPageWait.until(ExpectedConditions.visibilityOf(openPremiumPage)).click();
        return new PremiumPage(driverContainer);
    }

    public void checkPremiumWidget() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(200));
        wait.until(ExpectedConditions.visibilityOf(checkPremiumWidget));
    }

    @FindBy(xpath = "//button[@data-testid='back-button']")
    private WebElement backButton;

    @FindBy(xpath = "//span[contains(text(), 'Премиум') or contains(text(), 'Private')]")
    private WebElement openPremiumPage;

    @FindBy(xpath = "//div[@data-testid='flexbox']/span[contains(text(), 'Премиум') or contains(text(), 'Private')]" )
    private WebElement checkPremiumWidget;
}
