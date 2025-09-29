package ru.mtsbank.likeCoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();
    protected WebDriver driver;
    protected ChromeOptions chromeOptions;
    private static final String URL_DEV = "https://online.mtsdengi-dev.mbrd.ru/";


    @BeforeClass
    public void setTup() {
        this.chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.setBrowserVersion("124");

        this.driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        this.driverContainer.set(driver);
        driverContainer.get().get(URL_DEV);
    }


}
