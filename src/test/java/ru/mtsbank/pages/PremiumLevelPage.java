package ru.mtsbank.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
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

    public String checkLevelSheet() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOf(openLevelSheet)).click();
        closeLevelSheet.click();
        return openLevelSheet.getText();
    }




    public void checkLevelPage() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(openServiceTerms)).click();

        wait.until(ExpectedConditions.visibilityOf(backButton)).click();

        wait.until(ExpectedConditions.visibilityOf(openFirstI)).click();

        wait.until(ExpectedConditions.visibilityOf(closeFirstI)).click();

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

}
