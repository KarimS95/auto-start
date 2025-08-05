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
import java.util.Set;

public class PremiumCashbackPage extends BasePage{

    public PremiumCashbackPage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public void openPremiumCashbackCategoriesList() {

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(openCategoriesList)).click();
    }

    public void selectCashbackCategories() {

       List<WebElement> checkboxes = driverContainer.get().findElements(By.xpath("//input[@role='checkbox']"));
       if(checkboxes.size() >= 5) {
           for(int i = 0; i < 5; i++) {
               checkboxes.get(i).click();
           }
       }

       selectCashbackCategories.click();
       selectOk.click();
    }

    public void openPremiumCashbackPrivilege() {

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(openPremiumCashbackPrivilege)).click();
    }

    public void checkLevelPageLink() throws InterruptedException {

       new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        try {
            openPremiumLink.click();
        } catch (StaleElementReferenceException e) {
            openPremiumLink.click();
        }
        Thread.sleep(5000);

        new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        backButton.click();
    }

    public void checkFirstLink() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));

        String generalWindowHandle = driverContainer.get().getWindowHandle();

        wait.until(ExpectedConditions.visibilityOf(openFirstLink)).click();

        Set<String> handles = driverContainer.get().getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(generalWindowHandle)) {
                Thread.sleep(7000);
                driverContainer.get().switchTo().window(handle).close();
                driverContainer.get().switchTo().window(generalWindowHandle);
            }
        }
    }

    public void checkSecondLink() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));

        String generalWindowHandle = driverContainer.get().getWindowHandle();
        openSecondLink.click();

        Set<String> handles = driverContainer.get().getWindowHandles();

        for (String handle : handles) {
            if (!handle.equals(generalWindowHandle)) {
                Thread.sleep(7000);
                driverContainer.get().switchTo().window(handle).close();
                driverContainer.get().switchTo().window(generalWindowHandle);
            }
        }
    }

    public void checkThirdLink() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));

        String thirdGeneralWindowHandle = driverContainer.get().getWindowHandle();
        openCashbackPdf.click();
        Set<String> thirdHandles = driverContainer.get().getWindowHandles();

        for(String handle : thirdHandles) {
            if(!handle.equals(thirdGeneralWindowHandle)) {
                Thread.sleep(7000);
                driverContainer.get().switchTo().window(handle).close();
                driverContainer.get().switchTo().window(thirdGeneralWindowHandle);
            }
        }
    }

    public void backToStartPage() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));


        WebDriverWait waitBackToPremium = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitBackToPremium.until(ExpectedConditions.visibilityOf(backButton)).click();

        WebDriverWait waitBackToGeneral = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        waitBackToGeneral.until(ExpectedConditions.visibilityOf(backButton)).click();
    }


    @FindBy(xpath = "//a[@href='/premium/cashback-category?fromDate=2025-08-01']")
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

}
