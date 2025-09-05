package ru.mtsbank.premium.web.mtsmoney.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

  public LoginPage(InheritableThreadLocal<WebDriver> driverContainer) {
      super(driverContainer);
  }

    public CodePage inputLogin(String phoneNumber) {
        WebDriverWait loginInputWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(200));
        loginInputWait.until(ExpectedConditions.visibilityOf(inputLogin));

        inputLogin.sendKeys(phoneNumber);
        nextButton.click();

        return new CodePage(driverContainer);
    }

    @FindBy(xpath = "//input[contains(@id,'login') or contains(@id,'phone')]")
    private WebElement inputLogin;

    @FindBy(xpath = "//span[text()='Далее'] | //button[text()='Далее']")
    private WebElement nextButton;
}