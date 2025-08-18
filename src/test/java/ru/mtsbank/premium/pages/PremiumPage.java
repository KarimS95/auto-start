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


    public PremiumLevelPage openPremiumLevelPage() {

        for (int i = 0; i < MAX_RETRIES; i++) {
            try {
                checkElementOnPage(openLevelPage);
                openLevelPage.click();
                break;

            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                System.out.println("Retries: " + i);
            }
        }
        return new PremiumLevelPage(driverContainer);
    }

    public boolean checkPremiumLevelPageIsClickable() {
        checkElementOnPage(openLevelPage);
        return openLevelPage.isEnabled();
    }

    public void openPremiumCashbackCategoriesList() {
        checkElementOnPage(openPremiumCashbackCategoriesList);
        openPremiumCashbackCategoriesList.click();
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
        checkElementOnPage(openPremiumCashbackCategoriesList);

        return openPremiumCashbackCategoriesList.isDisplayed() && openPremiumCashbackCategoriesList.isEnabled();
    }

    public PremiumCashbackPage openPremiumCashbackPrivilege() {
        checkElementOnPage(openPremiumCashbackPrivilege);
        openPremiumCashbackPrivilege.click();

        return new PremiumCashbackPage(driverContainer);
    }

    public boolean checkPremiumCashbackPrivilegeIsClickable() {
       checkElementOnPage(openPremiumCashbackPrivilege);
        return openPremiumCashbackPrivilege.isEnabled();
    }

    public String checkLevelPageHeaderName() {
       checkElementOnPage(checkLevelPageButton);
       return checkLevelPageButton.getText();
    }

    public boolean checkPrivilegesBlocksIsDisplayed() {
        checkElementOnPage(checkPrivilegesBlocks);
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

    @FindBy(xpath = "//p[contains(text(),'Уровень') or contains(text(), 'Private')]")
    private WebElement checkLevelPageButton;

    @FindBy(xpath = "//span[contains(text(), 'Мои привилегии')]")
    private WebElement checkPrivilegesBlocks;

   // private By checkPrivilegesBlocks = By.xpath("//span[contains(text(), 'Мои привилегии')]");


}
