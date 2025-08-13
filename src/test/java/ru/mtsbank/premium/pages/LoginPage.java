package ru.mtsbank.premium.pages;

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

    @FindBy(id = "login")
    private WebElement inputLogin;

    @FindBy(xpath = "//button[normalize-space()='Далее']")
    private WebElement nextButton;
}