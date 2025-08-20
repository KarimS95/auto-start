package ru.mtsbank.premium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PremiumCashbackPage extends BasePage{

    public PremiumCashbackPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public void openCategoriesList() {

        for(int i = 0; i < MAX_RETRIES; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(100));
                wait.until(ExpectedConditions.elementToBeClickable(openCategoriesList)).click();
                break;

            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                System.out.println("Retries: " + i);
            }
        }
    }

    public String getCategoriesListHeader() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(checkCategoriesListHeaderText));

        return checkCategoriesListHeaderText.getText();
    }

    public int getCheckboxesCount() {
        return driverContainer.get().findElements(checkboxesByLocator).size();
    }

    public void selectCashbackCategoriesCheckboxes() {

       List<WebElement> checkboxes = driverContainer.get().findElements(By.xpath("//input[@role='checkbox']"));

       if(checkboxes.size() >= 5) {
           for(WebElement checkbox : checkboxes) {
               checkbox.click();
           }
       }
    }

    public void clickOnCategoriesSelectButton() {
        selectCashbackCategories.click();
    }

    public PremiumCashbackPage clickOnSuccessfulButton() {
        selectOk.click();
        return new PremiumCashbackPage(driverContainer);
    }

    public boolean checkSelectedCategories() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(checkSelectedCategories));
        return checkSelectedCategories.isDisplayed();
    }

    public String openLevelPageLink() {
        WebDriverWait waitPremiumLink = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitPremiumLink.until(ExpectedConditions.elementToBeClickable(openPremiumLink)).click();

        return driverContainer.get().getCurrentUrl();
    }

    public String getLevelPageHeader() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(checkPremiumLevelPageHeader));

        return checkPremiumLevelPageHeader.getText();
    }

    public String backToCashbackPrivilege() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(backButton));
        backButton.click();
        return driverContainer.get().getCurrentUrl();
    }

    public boolean openFirstLink()  {
        boolean isTrue = false;
        String generalWindowHandle = driverContainer.get().getWindowHandle();
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(120));
        wait.until(ExpectedConditions.visibilityOf(openFirstLink));

        ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].scrollIntoView(true)", openFirstLink);
        openFirstLink.click();

        Set<String> handles = driverContainer.get().getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(generalWindowHandle)) {
                driverContainer.get().switchTo().window(handle);
                isTrue = Objects.equals(driverContainer.get().getCurrentUrl(), checkFirstLink);
                driverContainer.get().close();
                driverContainer.get().switchTo().window(generalWindowHandle);
            }
        }
        return isTrue;
    }

    public boolean openSecondLink() {
        boolean isTrue = false;
        String generalWindowHandle = driverContainer.get().getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openSecondLink)).click();

        Set<String> handles = driverContainer.get().getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(generalWindowHandle)) {
                driverContainer.get().switchTo().window(handle);
                isTrue = Objects.equals(driverContainer.get().getCurrentUrl(), checkSecondLink);
                driverContainer.get().close();
                driverContainer.get().switchTo().window(generalWindowHandle);
            }
       }
        return isTrue;
    }

    public boolean openThirdLink() {
        boolean isTrue = false;
        String generalWindowHandle = driverContainer.get().getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openCashbackPdf)).click();

        Set<String> handles = driverContainer.get().getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(generalWindowHandle)) {
                driverContainer.get().switchTo().window(handle);
                isTrue = Objects.equals(driverContainer.get().getCurrentUrl(), checkThirdLink);
                driverContainer.get().close();
                driverContainer.get().switchTo().window(generalWindowHandle);
            }
        }
        return isTrue;
    }


//
//    public void backToStartPage() throws InterruptedException {
//
//        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
//
//
//        WebDriverWait waitBackToPremium = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
//        waitBackToPremium.until(ExpectedConditions.visibilityOf(backButton)).click();
//
//        WebDriverWait waitBackToGeneral = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
//        waitBackToGeneral.until(ExpectedConditions.visibilityOf(backButton)).click();
//    }


    @FindBy(xpath = "//a[contains(@href, '/premium/cashback-category?fromDate=')]")
    private WebElement openCategoriesList;

    @FindBy(xpath = "//span[text()='Выбрать']")
    private WebElement selectCashbackCategories;

    @FindBy(xpath = "//input[@role='checkbox']")
    private WebElement checkboxes;

    @FindBy(xpath = "//span[normalize-space()='Хорошо']")
    private WebElement selectOk;

    @FindBy(xpath = "//a[@href='/premium/cashback']")
    private WebElement openPremiumCashbackPrivilege;

    @FindBy(xpath = "//a[@href='https://vamprivet.ru/supreme-restaurants/']")
    private WebElement openFirstLink;

    @FindBy(xpath = "//a[@href='https://vamprivet.ru/afisha/']")
    private WebElement openSecondLink;

    @FindBy(xpath = "//a[@href='https://static.mtsdengi.ru/portal-frontend-premium/documents/usloviya-nachisleniya-keshbehka-dlya-debetovyh-kart-v-ramkah.pdf']")
    private WebElement openCashbackPdf;

    @FindBy(xpath = "//button[@data-testid='back-button']")
    private WebElement backButton;

    @FindBy(xpath = "//a[@href='/premium/level']")
    private WebElement openPremiumLink;

    @FindBy(xpath = "//div[contains(text(), 'кешбэк')]")
    private WebElement checkCategoriesListHeaderText;

    @FindBy(xpath = "//div[contains(text(), 'Премиальное обслуживание')]")
    private WebElement checkPremiumLevelPageHeader;

    @FindBy(xpath = "//span[contains(text(), 'Повышенный кешбэк в')]")
    private WebElement checkSelectedCategories;


    private By checkLevelPageIsDisplayed = By.xpath("//a[@href='/premium/level']");
    private String checkFirstLink = "https://vamprivet.ru/supreme-restaurants/";
    private String checkSecondLink = "https://vamprivet.ru/afisha/";
    private String checkThirdLink = "https://static.mtsdengi.ru/portal-frontend-premium/documents/usloviya-nachisleniya-keshbehka-dlya-debetovyh-kart-v-ramkah.pdf";
    private By checkboxesByLocator = By.xpath("//input[@role='checkbox']");
    private By checkCategoriesList = By.xpath("//a[contains(@href, '/premium/cashback-category?fromDate=')]");

}
