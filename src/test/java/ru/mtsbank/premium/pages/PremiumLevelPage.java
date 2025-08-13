package ru.mtsbank.premium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    public boolean checkLevelSheetIsClickable() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openLevelSheet));
        return true;
    }

    public String checkClickLevelSheet() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(openLevelSheet)).click();
        closeLevelSheet.click();
        return openLevelSheet.getText();
    }

    public boolean checkServicesTermsButtonIsClickable() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openServiceTerms));

        return true;
    }

    public boolean checkOpenServicesTermsButton() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openServiceTerms)).click();

        boolean isTrue = Objects.equals(termsText.getText(), termsStringText);

        backButton.click();

        return isTrue;
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

    @FindBy(xpath = "//p[text()='Cреднемесячный остаток']/following::*[name()='svg'][1]")
    private WebElement openFirstI;

    @FindBy(xpath = "//p[text()='Cреднемесячный остаток']/following::*[name()='button'][1]")
    private WebElement closeFirstI;

    @FindBy(xpath = "")
    private WebElement openSecondI;

    @FindBy(xpath = "")
    private WebElement closeSecondI;

    @FindBy(xpath = "//div[@class='sc-gKlhbP dSUumu']//div[3]//div[2]//div[1]//*[name()='svg']//*[name()='path' and contains(@fill-rule,'evenodd')]")
    private WebElement openThirdI;

    @FindBy(xpath = "//*[name()='path' and contains(@d,'M6.293 16.')]")
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

    private String termsStringText = "Условия обслуживания";

}
