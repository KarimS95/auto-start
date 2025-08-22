package ru.mtsbank.premium.pages;

import org.openqa.selenium.By;
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

    public boolean checkPremiumWidget() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.elementToBeClickable(checkPremiumWidget));

        return checkPremiumWidget.isDisplayed() && checkPremiumWidget.isEnabled();
    }

    public String checkPremiumWidgetName() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(openPremiumPage));

        return openPremiumPage.getText();
    }

    public PremiumPage openPremiumPage() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(150));
        wait.until(ExpectedConditions.visibilityOf(openPremiumPage)).click();

        return new PremiumPage(driverContainer);
    }



    @FindBy(xpath = "//button[@data-testid='back-button']")
    private WebElement backButton;

    @FindBy(xpath = "//span[contains(text(), 'Премиум') or contains(text(), 'Private')]")
    private WebElement openPremiumPage;

    @FindBy(xpath = "//div[@data-testid='flexbox']/span[contains(text(), 'Премиум') or contains(text(), 'Private')]" )
    private WebElement checkPremiumWidget;

    private By premiumWidget = By.xpath("//div[@data-testid='flexbox']/span[contains(text(), 'Премиум') or contains(text(), 'Private')]");
}
