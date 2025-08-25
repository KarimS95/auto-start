package ru.mtsbank.hw.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecurePage extends BasePage {

    public SecurePage(InheritableThreadLocal<WebDriver> driverContainer) {
        super(driverContainer);
    }

    public String getAlert() {
        return alert.getText();
    }

    public String getSecurePageUrl() {
        return driverContainer.get().getCurrentUrl();
    }

    public List<String> getSecurePageTextInfo() {
        return Collections.singletonList(Arrays.asList(cardHeader.getText(),cardSubHeader.getText(),cardSubSubheader.getText()).toString());
    }

    public String getLogoutButtonText() {
        return logoutButton.getText();
    }

    public boolean isLogoutButtonInteractive() {
        return logoutButton.isDisplayed() && logoutButton.isEnabled();
    }

    public LoginPage logout() {
        logoutButton.click();
        return new LoginPage(driverContainer);
    }





    @FindBy(xpath = "//div[@id='flash']")
    private WebElement alert;

    @FindBy(xpath = "//h1")
    private WebElement cardHeader;

    @FindBy(xpath = "//h3[@id='username']")
    private WebElement cardSubHeader;

    @FindBy(xpath = "//h4[@class='subheader']")
    private WebElement cardSubSubheader;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutButton;

}
