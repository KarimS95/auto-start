package ru.mtsbank.premium.web.mtsbanksite.pages;

import org.openqa.selenium.Keys;
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

    public String getAboutServicesTabText() {
        return aboutServicesTab.getText();
    }

    public String getServicesAndTariffsTabText() {
        return servicesAndTariffsTab.getText();
    }

    public String getPremiumServiceHeader() {
        return premiumServiceHeader.getText();
    }

    public void clickFirstButton() {
       js("arguments[0].click();",afterHeaderFirstButton);
    }

    public String getNextButtonText() {
        return nextButton.getText();
    }

    public boolean checkNextButtonDisable() {
        return nextButton.getAttribute("disabled") != null;
    }






    @FindBy(xpath = "//h1[text()='Премиальное обслуживание']")
    private WebElement premiumPageGeneralHeader;

    @FindBy(xpath = "//ul")
    private WebElement afterHeaderText;

    @FindBy(xpath = "//div[@data-testid='flexbox']/button[@data-testid='button'][1]")
    private WebElement afterHeaderFirstButton;

    @FindBy(xpath = "//div[@data-testid='flexbox']/button[@data-testid='button'][2]")
    private WebElement afterHeaderSecondButton;

    @FindBy(xpath = "//div[contains(text(),'Об услугах')]")
    private WebElement aboutServicesTab;

    @FindBy(xpath = "//div[contains(text(),'Сервисы и тарифы')]")
    private WebElement servicesAndTariffsTab;

    @FindBy(xpath = "//h2[text()='Премиальное обслуживание']")
    private WebElement premiumServiceHeader;

    @FindBy(xpath = "//h2[@data-testid='heading' and contains(text(),'Закажите карту')]")
    private WebElement cardOrderHeader;

    @FindBy(xpath = "//button[@data-testid='button'][.//text()='Продолжить']")
    private WebElement nextButton;


}
