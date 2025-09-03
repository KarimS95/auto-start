package ru.mtsbank.premium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class PremiumCashbackPage extends BasePage{

    public PremiumCashbackPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }


    public String getBaseCashbackBlockHeader() {
        return baseCashbackBlockHeader.getText();
    }

    public String getIncreasedCashbackBlockHeader() {
        return increasedCashbackBlockHeader.getText();
    }

    public String getSubscriptionBlockHeader() {
        return subscriptionBlockHeader.getText();
    }

    public String getFromPaymentSystemBlockHeder() {
        return fromPaymentSystemBlockHeader.getText();
    }

    public String getHowToGetBlockHeader() {
        return howToGetBlockHeader.getText();
    }

    public boolean checkSelectCashbackCategoriesButton() {
        return selectCashbackCategoriesButton.isDisplayed() && selectCashbackCategoriesButton.isEnabled();
    }


    public void openCategoriesList() {

        for(int i = 0; i < MAX_RETRIES; i++) {
            try {
                WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
                ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].scrollIntoView({block:'center'});",openCategoriesList);
                wait.until(ExpectedConditions.elementToBeClickable(openCategoriesList)).click();
                break;

            } catch (StaleElementReferenceException | ElementNotInteractableException e) {
                System.out.println("Retries: " + i);
            }
        }
    }

    public String getCategoriesListHeader() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(checkCategoriesListHeaderText));

        return checkCategoriesListHeaderText.getText();
    }

    public int getCheckboxesCount() {
        return driverContainer.get().findElements(checkboxesByLocator).size();
    }

    public boolean checkCheckboxes() {
        return checkboxes.isEnabled();
    }

    public boolean checkDisableSelectButton() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(selectCashbackCategoriesLink));
        return selectCashbackCategoriesLink.getAttribute("disabled") != null;
    }

    public void selectCashbackCategoriesCheckboxes() {

       List<WebElement> checkboxesList = driverContainer.get().findElements(checkboxesByLocator);

       for (WebElement checkbox : checkboxesList) {
               checkbox.click();
           }
    }

    public boolean checkDisableCheckboxes() {
        List<WebElement> checkboxesList = driverContainer.get().findElements(checkboxesByLocator);

        boolean isTrue = false;

        for (WebElement i : checkboxesList) {
            isTrue = (!i.isSelected()) && i.getAttribute("disabled") != null;
        }
        return isTrue;
    }

    public boolean checkEnableSelectButton() {
        return selectCashbackCategoriesLink.isEnabled();
    }

    public void clickOnCategoriesSelectButton() {
        selectCashbackCategoriesLink.click();
    }

    public boolean checkSelectButton() {
        return selectOk.isDisplayed() && selectOk.isEnabled();
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
        WebDriverWait waitPremiumLink = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        waitPremiumLink.until(ExpectedConditions.elementToBeClickable(openPremiumLink)).click();

        return driverContainer.get().getCurrentUrl();
    }

    public String getLevelPageHeader() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(checkPremiumLevelPageHeader));

        return checkPremiumLevelPageHeader.getText();
    }

    public String backToCashbackPrivilege() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(backButton));
        backButton.click();
        return driverContainer.get().getCurrentUrl();
    }

    public String openFirstLink()  {
        String URL = "";
        String generalWindowHandle = driverContainer.get().getWindowHandle();

        ((JavascriptExecutor)driverContainer.get()).executeScript("arguments[0].scrollIntoView(true);",openFirstLink);
        openFirstLink.click();

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

    public String openSecondLink() {
        String URL = "";
        String generalWindowHandle = driverContainer.get().getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openSecondLink));
        openSecondLink.click();

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

    public String openThirdLink() {
        String URL = "";
        String generalWindowHandle = driverContainer.get().getWindowHandle();

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(openCashbackPdf));
        openCashbackPdf.click();

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


    public String getPremiumCashbackPageURL() {
        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        String URL = driverContainer.get().getCurrentUrl();
        wait.until(ExpectedConditions.urlToBe(URL));
        return URL;
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
    private WebElement selectCashbackCategoriesLink;

    @FindBy(xpath = "//button[contains(.,'Выбрать')]")
    private WebElement selectCashbackCategoriesButton;

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

    @FindBy(xpath = "//span[text()='Базовый кешбэк']")
    private WebElement baseCashbackBlockHeader;

    @FindBy(xpath = "//span[text()='Повышенный кешбэк']")
    private WebElement increasedCashbackBlockHeader;

    @FindBy(xpath = "//span[text()='С подпиской МТС PREMIUM']")
    private WebElement subscriptionBlockHeader;

    @FindBy(xpath = "//span[text()='От платежной системы МИР']")
    private WebElement fromPaymentSystemBlockHeader;

    @FindBy(xpath = "//span[text()='Как получить']")
    private WebElement howToGetBlockHeader;


    private By checkLevelPageIsDisplayed = By.xpath("//a[@href='/premium/level']");
    private String checkFirstLink = "https://vamprivet.ru/supreme-restaurants/";
    private String checkSecondLink = "https://vamprivet.ru/afisha/";
    private String checkThirdLink = "https://static.mtsdengi.ru/portal-frontend-premium/documents/usloviya-nachisleniya-keshbehka-dlya-debetovyh-kart-v-ramkah.pdf";
    private By checkboxesByLocator = By.xpath("//input[@role='checkbox']");
    private By checkCategoriesList = By.xpath("//a[contains(@href, '/premium/cashback-category?fromDate=')]");

}