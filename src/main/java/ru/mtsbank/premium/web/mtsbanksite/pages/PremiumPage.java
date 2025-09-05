package ru.mtsbank.premium.web.mtsbanksite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PremiumPage extends BasePage {

    public PremiumPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }


    public String getPremiumPageUrl() {
        waitElement().until(ExpectedConditions.urlContains("https://"));
        return driverContainer.get().getCurrentUrl();
    }

    public String getPremiumPageGeneralHeader() {
        return premiumPageGeneralHeader.getText();
    }

    public String getAfterHeaderText() {
        return afterHeaderText.getText();
    }

    public String getAfterHeaderFirstButtonText() {
        return afterHeaderFirstButton.getText();
    }

    public String getAfterHeaderSecondButtonText() {
        return afterHeaderSecondButton.getText();
    }

    public boolean checkAfterHeaderFirstButton() {
        return afterHeaderFirstButton.isDisplayed() && afterHeaderFirstButton.isEnabled();
    }

    public boolean checkAfterHeaderSecondButton() {
        return afterHeaderSecondButton.isDisplayed() && afterHeaderSecondButton.isEnabled();
    }






    @FindBy(xpath = "//h1[text()='Премиальное обслуживание']")
    private WebElement premiumPageGeneralHeader;

    @FindBy(xpath = "//ul")
    private WebElement afterHeaderText;

    @FindBy(xpath = "//div[@data-testid='flexbox']/button[@data-testid='button'][1]")
    private WebElement afterHeaderFirstButton;

    @FindBy(xpath = "//div[@data-testid='flexbox']/button[@data-testid='button'][2]")
    private WebElement afterHeaderSecondButton;


}
