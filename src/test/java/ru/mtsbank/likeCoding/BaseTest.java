package ru.mtsbank.likeCoding;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {


    InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();
    WebDriver driver;
    ChromeOptions options;

    private final String URL_DEV = "https://online.mtsdengi-dev.mbrd.ru";

    @BeforeClass
    public void setUp() {
        this.options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setBrowserVersion("124");

        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        this.driverContainer.set(driver);
        this.driverContainer.get().get(URL_DEV);
    }

}
