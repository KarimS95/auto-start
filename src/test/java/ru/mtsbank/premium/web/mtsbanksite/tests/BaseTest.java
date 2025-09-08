package ru.mtsbank.premium.web.mtsbanksite.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import ru.mtsbank.premium.web.mtsbanksite.constans.Constants;

import java.time.Duration;

public class BaseTest {

    InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();

    WebDriver driver;
    ChromeOptions options;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        this.options = new ChromeOptions();
        options.setBrowserVersion("116");
        options.addArguments("--incognito");

        this.driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driverContainer.set(driver);
        driverContainer.get().get(Constants.PREMIUM_TEST_URL.getStringValue());
    }

}
