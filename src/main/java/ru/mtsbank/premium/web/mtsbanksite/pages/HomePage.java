package ru.mtsbank.premium.web.mtsbanksite.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }


    public String getPremiumText() {
        return searchPremiumLink.getText();
    }

    public PremiumPage openPremiumLink() {
        searchPremiumLink.click();
        return new PremiumPage(driverContainer);
    }









    @FindBy(xpath = "//a[@data-testid='link'][text()='Премиум']")
    private WebElement searchPremiumLink;

}
