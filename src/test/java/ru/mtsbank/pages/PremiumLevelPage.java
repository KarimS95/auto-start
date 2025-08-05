package ru.mtsbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class PremiumLevelPage extends BasePage {

    public PremiumLevelPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public void openLevelPage() {

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(openLevelPage)).click();
    }

    public void checkLevelPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(openLevelSheet)).click();

        wait.until(ExpectedConditions.visibilityOf(closeLevelSheet)).click();

        wait.until(ExpectedConditions.visibilityOf(openServiceTerms)).click();

        wait.until(ExpectedConditions.visibilityOf(backButton)).click();

//        wait.until(ExpectedConditions.visibilityOf(openFirstI));
//        openFirstI.click();
//
//        wait.until(ExpectedConditions.visibilityOf(closeFirstI));
//        closeFirstI.click();
//
//        wait.until(ExpectedConditions.visibilityOf(openSecondI));
//        openSecondI.click();
//
//        wait.until(ExpectedConditions.visibilityOf(closeSecondI));
//        closeSecondI.click();
//
//        wait.until(ExpectedConditions.visibilityOf(openThirdI));
//        openThirdI.click();
//
//        wait.until(ExpectedConditions.visibilityOf(closeThirdI));
//        closeThirdI.click();

        String firstHandle = driverContainer.get().getWindowHandle();
        wait.until(ExpectedConditions.visibilityOf(openLink));
        openLink.click();

        Set<String> handles = driverContainer.get().getWindowHandles();
        for (String handle : handles) {
            if (!handle.equals(firstHandle)) {
                Thread.sleep(7000);
                driverContainer.get().switchTo().window(handle).close();
                driverContainer.get().switchTo().window(firstHandle);
            }
        }

        wait.until(ExpectedConditions.visibilityOf(backToPremiumPage));
        backToPremiumPage.click();

        wait.until(ExpectedConditions.visibilityOf(backToGeneralPage));
        backToGeneralPage.click();
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

    @FindBy(xpath = "//p[text()='Среднемесячный остаток']/../../div/*/svg")
    private WebElement openFirstI;

    @FindBy(xpath = "//h4[contains(text(), 'Среднемесячный остаток')]/following::button[1]")
    private WebElement closeFirstI;

    @FindBy(xpath = "")
    private WebElement openSecondI;

    @FindBy(xpath = "//h4[contains(text), 'Покупки по премиальным картам']/following::button[1]")
    private  WebElement closeSecondI;

    @FindBy(xpath = "")
    private  WebElement openThirdI;

    @FindBy(xpath = "//h4[contains(text), 'Среднемесячный остаток на тек']/following::button[1]")
    private WebElement closeThirdI;

    @FindBy(xpath = "//a[contains(@href,'pdf')]")
    private WebElement openLink;

    @FindBy(xpath = "//button[@data-testid='back-button']")
    private WebElement backToPremiumPage;

    @FindBy(xpath = "//button[@data-testid='back-button']")
    private WebElement backToGeneralPage;

}
