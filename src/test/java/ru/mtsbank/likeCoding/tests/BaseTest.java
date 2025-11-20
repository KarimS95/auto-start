package ru.mtsbank.likeCoding.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.mtsbank.likecoding.CodePage;
import ru.mtsbank.likecoding.LoginPage;

import java.time.Duration;

import static ru.mtsbank.likeCoding.data.TestData.*;

public class BaseTest {

    InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();
    WebDriver driver;
    ChromeOptions options;
    String actualResult;


    @BeforeClass
    public void setUp() {
        this.options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setBrowserVersion("125");

        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driverContainer.set(driver);
        driverContainer.get().get(URL_UAT);
    }

    @BeforeClass(dependsOnMethods = "setUp")
    public void testAuthorization() {
        LoginPage loginPage = new LoginPage(driverContainer);
        CodePage codePage = loginPage.login(PHONE_NUMBER);
        codePage.inputCode(CODE_LIST);

        actualResult = codePage.getErrorLabelText();
    }
}
