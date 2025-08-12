package ru.mtsbank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PremiumCashbackPage extends BasePage{

    public PremiumCashbackPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public boolean categoriesListIsDisplaying() {
        WebDriverWait waitCategoriesListButton = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(120));
        waitCategoriesListButton.until(ExpectedConditions.visibilityOfElementLocated(checkCategoriesList));
        return true;
    }

    public void openCategoriesList() {
        try {
            WebDriverWait waitCategoriesListButton = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(120));
            waitCategoriesListButton.until(ExpectedConditions.elementToBeClickable(openCategoriesList)).click();
        } catch (StaleElementReferenceException e) {
            WebDriverWait waitCategoriesListButton = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(120));
            waitCategoriesListButton.until(ExpectedConditions.elementToBeClickable(openCategoriesList)).click();
        }
    }

    public String getCategoriesHeader() {
        return checkCategoriesListHeaderText.getText();
    }

    public int checkboxesCount() {
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

    public PremiumCashbackPage clickOnSuccessfullButton() {
        selectOk.click();
        return new PremiumCashbackPage(driverContainer);
    }

    public boolean selectedCategoriesDisplaying() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkSelectedCategories));
        return true;
    }

    public boolean checkLevelPageLinkIsDisplayed() throws InterruptedException {
       WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(120));
       wait.until(ExpectedConditions.visibilityOfElementLocated(checkLevelPageIsDisplayed));
       return true;
    }

    public boolean checkLevelPageLinkIsClickable() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(openPremiumLink));
        return true;
    }


    public boolean checkFirstLink()  {
        boolean isTrue = false;
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        String generalWindowHandle = driverContainer.get().getWindowHandle();

        wait.until(ExpectedConditions.visibilityOf(openFirstLink)).click();

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

    public boolean checkSecondLink() {
        boolean isTrue = false;

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));

        String generalWindowHandle = driverContainer.get().getWindowHandle();
        wait.until(ExpectedConditions.visibilityOf(openSecondLink)).click();

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

    public boolean checkThirdLink() {
        boolean isTrue = false;

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));

        String generalWindowHandle = driverContainer.get().getWindowHandle();
        wait.until(ExpectedConditions.visibilityOf(openCashbackPdf)).click();

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


    private By checkLevelPageIsDisplayed = By.xpath("//a[@href='/premium/level']");
    private String checkFirstLink = "https://vamprivet.ru/supreme-restaurants/";
    private String checkSecondLink = "https://vamprivet.ru/afisha/";
    private String checkThirdLink = "https://static.mtsdengi.ru/portal-frontend-premium/documents/usloviya-nachisleniya-keshbehka-dlya-debetovyh-kart-v-ramkah.pdf";
    private By checkboxesByLocator = By.xpath("//input[@role='checkbox']");
    private By checkSelectedCategories = By.xpath("//span[contains(text(), 'Повышенный кешбэк в')]");
    private By checkCategoriesList = By.xpath("//a[contains(@href, '/premium/cashback-category?fromDate=')]");

}
