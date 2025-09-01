package ru.mtsbank.premium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PremiumPage extends BasePage{

    public PremiumPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public String checkManagerBlock() {
        return managerBlock.getText();
    }

    public String getCallButtonName() {
        return callButton.getText();
    }

    public String getMassageButtonName() {
        return messageButton.getText();
    }

    public boolean checkCallButton() {
        return callButton.isDisplayed() && callButton.isEnabled();
    }

    public boolean checkMessageButton() {
        return messageButton.isDisplayed() && messageButton.isEnabled();
    }


    public PremiumLevelPage openPremiumLevelPage() {

        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].click();",openLevelPage);
                break;

            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                System.out.println("Retries: " + i);
            }
        }
        return new PremiumLevelPage(driverContainer);
    }

    public boolean checkPremiumLevelPage() {
        return openLevelPage.isDisplayed() && openLevelPage.isEnabled();
    }

    public void openPremiumCashbackCategoriesList() {
        checkElementOnPage(openPremiumCashbackCategoriesList);
        openPremiumCashbackCategoriesList.click();
    }

    public void selectCashbackCategories() {

        List<WebElement> checkboxes = driverContainer.get().findElements(By.xpath("//input[@role='checkbox']"));

        for(WebElement checkbox : checkboxes) {
                checkbox.click();
        }
    }

    public void clickOnCategoriesSelectButton() {
        selectCashbackCategories.click();
    }

    public PremiumPage clickOnSuccessfulButton() {
        selectOk.click();
        return new PremiumPage(driverContainer);
    }

    public boolean checkPremiumCashbackCategoriesList() {
        return openPremiumCashbackCategoriesList.isDisplayed() && openPremiumCashbackCategoriesList.isEnabled();
    }

    public PremiumCashbackPage openPremiumCashbackPrivilege() {
        openPremiumCashbackPrivilege.click();
        return new PremiumCashbackPage(driverContainer);
    }

    public boolean checkPremiumCashbackPrivilege() {
        return openPremiumCashbackPrivilege.isDisplayed() && openPremiumCashbackPrivilege.isEnabled();
    }

    public String checkLevelPageHeaderName() {
       return checkLevelPageButton.getText();
    }

    public boolean checkPrivilegesBlocks() {
        return checkPrivilegesBlocks.isDisplayed();
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

    @FindBy(xpath = "//div[@data-testid='flexbox'][contains(.,'Уровень') or contains(.,'Private')]")
    private WebElement checkLevelPageButton;

    @FindBy(xpath = "//span[contains(text(), 'Мои привилегии')]")
    private WebElement checkPrivilegesBlocks;

    @FindBy(xpath = "//div[@data-testid='flexbox'][contains(.,'менеджер')]")
    private WebElement managerBlock;

    @FindBy(xpath = "//button[@type='button'][contains(.,'позвонить')]")
    private WebElement callButton;

    @FindBy(xpath = "//button[@type='button'][contains(.,'написать')]")
    private WebElement messageButton;



   // private By checkPrivilegesBlocks = By.xpath("//span[contains(text(), 'Мои привилегии')]");


}
