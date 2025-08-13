package ru.mtsbank.premium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PremiumPage extends BasePage{

    public PremiumPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }


    public PremiumLevelPage openPremiumLevelPage() {
        try {
            WebDriverWait levelPageWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(100));
            levelPageWait.until(ExpectedConditions.visibilityOf(openLevelPage)).click();

        } catch (StaleElementReferenceException e) {
            WebDriverWait levelPageWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(100));
            levelPageWait.until(ExpectedConditions.visibilityOf(openLevelPage)).click();
        }

        return new PremiumLevelPage(driverContainer);
    }

    public boolean checkPremiumLevelPageIsClickable() {
        WebDriverWait levelPageWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        levelPageWait.until(ExpectedConditions.elementToBeClickable(openLevelPage)).isEnabled();

        return true;
    }

    public void openPremiumCashbackCategoriesList() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(openPremiumCashbackCategoriesList)).click();

    }

    public PremiumPage selectCashbackCategories() {

        List<WebElement> checkboxes = driverContainer.get().findElements(By.xpath("//input[@role='checkbox']"));

        if(checkboxes.size() >= 5) {
            for(WebElement checkbox : checkboxes) {
                checkbox.click();
            }
        }

        selectCashbackCategories.click();
        selectOk.click();

        return new PremiumPage(driverContainer);
    }

    public boolean checkPremiumCashbackCategoriesListIsClickable() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openPremiumCashbackCategoriesList));

        return true;
    }

    public PremiumCashbackPage openPremiumCashbackPrivilege() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(openPremiumCashbackPrivilege)).click();

        return new PremiumCashbackPage(driverContainer);
    }

    public boolean checkPremiumCashbackPrivilegeIsClickable() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openPremiumCashbackPrivilege));

        return true;
    }

    public String checkLevelPageHeaderName() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(checkLevelPageButton));

        return checkLevelPageButton.getText();
    }

    public boolean checkPrivilegesBlocksIsDisplayed() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkPrivilegesBlocks));

        return true;
    }






    @FindBy(xpath = "//a[@href='/premium/level']")
    private WebElement openLevelPage;

    @FindBy(xpath = "//a[contains(@href, '/premium/cashback-category?fromDate=')]")
    private WebElement openPremiumCashbackCategoriesList;

    @FindBy(xpath = "//a[@href='/premium/cashback']")
    private WebElement openPremiumCashbackPrivilege;

    @FindBy(xpath = "//span[contains(text(), 'Премиум') or contains(text(), 'Private')]")
    private WebElement openPremiumPage;

    @FindBy(xpath = "//div[@data-testid='flexbox']/span[contains(text(), 'Премиум') or contains(text(), 'Private')]" )
    private WebElement checkPremiumWidget;

    @FindBy(xpath = "//span[text()='Выбрать']")
    private WebElement selectCashbackCategories;

    @FindBy(xpath = "//input[@role='checkbox']")
    private WebElement checkboxes;

    @FindBy(xpath = "//span[normalize-space()='Хорошо']")
    private WebElement selectOk;

    @FindBy(xpath = "//p[contains(text(),'Уровень') or contains(text(), 'Private')]")
    private WebElement checkLevelPageButton;

    private By checkPrivilegesBlocks = By.xpath("//span[contains(text(), 'Мои привилегии')]");


}
