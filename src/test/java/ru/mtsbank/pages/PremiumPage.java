package ru.mtsbank.pages;

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

    public void openPremiumPage() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(openPremiumPage));

        openPremiumPage.click();
    }

    @FindBy(xpath = "//span[contains(text(), 'Премиум') or contains(text(), 'Private')]")
    private static WebElement openPremiumPage;

}
