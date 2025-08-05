package ru.mtsbank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage extends BasePage {

  public LoginPage(InheritableThreadLocal<WebDriver> driverContainer) {
      super(driverContainer);
  }

    public void auth(String phoneNumber, List<String> passwordList) throws InterruptedException {
        WebDriverWait loginInputWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        loginInputWait.until(ExpectedConditions.visibilityOf(inputLogin));

        inputLogin.sendKeys(phoneNumber);
        nextButton.click();

        for(String i: passwordList) {
            inputCode.sendKeys(i);
        }

        Thread.sleep(20000);
    }

    @FindBy(id = "login")
    private WebElement inputLogin;

    @FindBy(xpath = "//button[normalize-space()='Далее']")
    private WebElement nextButton;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement inputCode;
}
