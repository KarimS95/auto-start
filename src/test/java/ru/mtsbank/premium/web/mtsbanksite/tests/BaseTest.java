package ru.mtsbank.premium.web.mtsbanksite.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    private final String URL_TEST = "https://site-pred1.mbrd.ru/";

    InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();

    WebDriver driver;
    ChromeOptions options;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        this.options = new ChromeOptions();
        options.setBrowserVersion("138");
        options.addArguments("--incognito");

        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driverContainer.set(driver);
        driverContainer.get().get(URL_TEST);
    }

}
