package ru.mtsbank.premium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PremiumLevelPage extends BasePage {

    public PremiumLevelPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public String checkLevelPageHeaderName() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(getLevelPageHeader));

        return getLevelPageHeader.getText();
    }

    public String checkClickLevelSheet() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(openLevelSheet)).click();
        closeLevelSheet.click();
        return openLevelSheet.getText();
    }

    public String checkOpenServicesTermsButton() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openServiceTerms)).click();

        return termsText.getText();
    }

    public void returnBack() {
        backButton.click();
    }

    public void checkFirstI() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openFirstI)).click();
        closeFirstI.click();
    }

    public void checkSecondI() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openSecondI)).click();
        closeSecondI.click();
    }

    public void checkThirdI() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openThirdI)).click();
        closeThirdI.click();
    }






    @FindBy(xpath = "//a[@href='/premium/level']")
    private WebElement openLevelPage;

    @FindBy(xpath = "//span[contains(text(),'Мой уровень в')]")
    private WebElement openLevelSheet;

    @FindBy(xpath = "//h4[contains(text(), 'Мой уровень')]/following::button[1]")
    private WebElement closeLevelSheet;

    @FindBy(xpath = "//span[text()='Условия обслуживания']")
    private WebElement openServiceTerms;

    @FindBy(xpath = "//button[@data-testid='back-button']")
    private WebElement backButton;

    @FindBy(xpath = "//div[@class='sc-bSoFTp gkRNID']//div[2]//div[1]//div[1]//div[2]//div[1]//*[name()='svg']")
    private WebElement openFirstI;

    @FindBy(xpath = "//button[@class='sc-dTWiOz HXJNV sc-eJoXEY iskrJj sc-gtURjR esVnOE']")
    private WebElement closeFirstI;

    @FindBy(xpath = "//div[@class='sc-hdBJTi iua-dQD sc-ceUeOH fdLlLH']//div[2]//div[2]//div[1]//*[name()='svg']")
    private WebElement openSecondI;

    @FindBy(xpath = "//button[@class='sc-dTWiOz HXJNV sc-eJoXEY iskrJj sc-gtURjR esVnOE']")
    private WebElement closeSecondI;

    @FindBy(xpath = "//div[@class='sc-bJFmQb uedPQ']//div[3]//div[2]//div[1]//*[name()='svg']")
    private WebElement openThirdI;

    @FindBy(xpath = "(//button[@class='sc-dTWiOz HXJNV sc-eJoXEY iskrJj sc-gtURjR esVnOE'])[1]")
    private WebElement closeThirdI;

    @FindBy(xpath = "//a[contains(@href,'pdf')]")
    private WebElement openLink;

    @FindBy(xpath = "//button[@data-testid='back-button']")
    private WebElement backToPremiumPage;

    @FindBy(xpath = "//button[@data-testid='back-button']")
    private WebElement backToGeneralPage;

    @FindBy(xpath = "//div[contains(text(), 'Условия')]")
    private WebElement termsText;

    @FindBy(xpath = "//div[contains(text(), 'Премиальное обслуживание')]")
    private WebElement getLevelPageHeader;

    private By byOpenLevelSheet = By.xpath("//span[contains(text(),'Мой уровень в')]");
    private By byOpenServicesTermsButton = By.xpath("//span[text()='Условия обслуживания']");

}
