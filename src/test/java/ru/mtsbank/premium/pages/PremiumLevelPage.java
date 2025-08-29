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

    public String getLevelPageHeader() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(getLevelPageHeader));
        return getLevelPageHeader.getText();
    }

    public String openLevelSheet() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(openLevelSheet)).click();
        return openLevelSheet.getText();
    }

    public void closeLevelSheet() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(closeLevelSheet)).click();
    }

    public String openServicesTermsListButton() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openServiceTerms)).click();
        return termsHeader.getText();
    }

    public String getCardHeaderTermsList() {
        return termsCardHeader.getText();
    }

    public String getLevelsTermsList() {
        return levelsTerms.getText();
    }

    public void returnBack() {
        backButton.click();
    }

    public String openFirstI() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openFirstI)).click();

        return firstIHeader.getText();
    }

    public String openSecondI() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openSecondI)).click();

        return secondIHeader.getText();
    }

    public String openThirdI() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openThirdI)).click();
        return thirdIHeader.getText();
    }

    public void closeI() {
        closeFirstI.click();
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

    @FindBy(xpath = "(//*[name()='svg'][@class='sc-dTvVRJ ketkom'])[2]")
    private WebElement openFirstI;

    @FindBy(xpath = "//h4[text()='Cреднемесячный остаток']")
    private WebElement firstIHeader;

    @FindBy(xpath = "//p[contains(text(),'Покупки')]")
    private WebElement secondIHeader;

    @FindBy(xpath = "//p[contains(text(),'Cреднемесячный остаток на тек')]")
    private WebElement thirdIHeader;

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M6.293 16.')]")
    private WebElement closeFirstI;

    @FindBy(xpath = "(//*[name()='svg'][@class='sc-dTvVRJ ketkom'])[3]")
    private WebElement openSecondI;

    @FindBy(xpath = "(//*[name()='svg'][@class='sc-dTvVRJ ketkom'])[5]")
    private WebElement closeSecondI;

    @FindBy(xpath = "(//*[name()='svg'][@class='sc-dTvVRJ ketkom'])[4]")
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
    private WebElement termsHeader;

    @FindBy(xpath = "//span[1]")
    private WebElement termsCardHeader;

    @FindBy(xpath = "//ol[@role='list']")
    private WebElement levelsTerms;

    @FindBy(xpath = "//div[contains(text(), 'Премиальное обслуживание')]")
    private WebElement getLevelPageHeader;

    private By byOpenLevelSheet = By.xpath("//span[contains(text(),'Мой уровень в')]");
    private By byOpenServicesTermsButton = By.xpath("//span[text()='Условия обслуживания']");

}
