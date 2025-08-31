package ru.mtsbank.premium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

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
        wait.until(ExpectedConditions.visibilityOf(openLevelSheet));
        openLevelSheet.click();
        return openLevelSheet.getText();
    }

    public void closeLevelSheet() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(closeLevelSheet));
        closeLevelSheet.click();
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

        WebDriverWait waitHeader = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
        waitHeader.until(ExpectedConditions.visibilityOf(firstIHeader));

        return firstIHeader.getText();
    }

    public String openSecondI() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openSecondI)).click();

        WebDriverWait waitHeader = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
        waitHeader.until(ExpectedConditions.visibilityOf(secondIHeader));

        return secondIHeader.getText();
    }

    public String getPurchasesTermsPDF() {
        String URL = "";
        String generalWindowHandle = driverContainer.get().getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(purchasesTerms));
        purchasesTerms.sendKeys(Keys.SPACE);
        purchasesTerms.click();

        Set<String> handles = driverContainer.get().getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(generalWindowHandle)) {
                WebDriverWait waitURL = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
                waitURL.until(ExpectedConditions.urlContains("https://"));
                URL = driverContainer.get().switchTo().window(handle).getCurrentUrl();
                driverContainer.get().close();
                driverContainer.get().switchTo().window(generalWindowHandle);
            }
        }
        return URL;
    }

    public String openThirdI() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openThirdI)).click();

        WebDriverWait waitHeader = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
        waitHeader.until(ExpectedConditions.visibilityOf(thirdIHeader));

        return thirdIHeader.getText();
    }

    public void closeI() {
        closeI.click();
    }

    public String checkLevelRulesButton() {
        String URL = "";
        String generalWindowHandle = driverContainer.get().getWindowHandle();
        ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].scrollIntoView(true)",levelsRulesButton);
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(levelsRulesButton));
        levelsRulesButton.sendKeys(Keys.SPACE);
        levelsRulesButton.click();

        Set<String> handles = driverContainer.get().getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(generalWindowHandle)) {
                WebDriverWait waitURL = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
                waitURL.until(ExpectedConditions.urlContains("https://"));
                URL = driverContainer.get().switchTo().window(handle).getCurrentUrl();
                driverContainer.get().close();
                driverContainer.get().switchTo().window(generalWindowHandle);
            }
        }
        return URL;
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

    @FindBy(xpath = "(//*[name()='svg'])[12]")
    private WebElement openFirstI;

    @FindBy(xpath = "//h4[text()='Cреднемесячный остаток']")
    private WebElement firstIHeader;

    @FindBy(xpath = "//p[contains(text(),'Покупки')]")
    private WebElement secondIHeader;

    @FindBy(xpath = "//p[contains(text(),'Cреднемесячный остаток на тек')]")
    private WebElement thirdIHeader;

    @FindBy(xpath = "(//*[name()='svg'][@class='sc-dTvVRJ ketkom'])[6]")
    private WebElement closeI;

    @FindBy(xpath = "(//*[name()='svg'])[13]")
    private WebElement openSecondI;

    @FindBy(xpath = "(//*[name()='svg'])[14]")
    private WebElement openThirdI;

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

    @FindBy(xpath = "//a[contains(@href,'pravila-nachisleniya')]")
    private WebElement purchasesTerms;

    @FindBy(xpath = "//a[contains(@href,'moj-uroven')]")
    private WebElement levelsRulesButton;

    private By byOpenLevelSheet = By.xpath("//span[contains(text(),'Мой уровень в')]");
    private By byOpenServicesTermsButton = By.xpath("//span[text()='Условия обслуживания']");

}
