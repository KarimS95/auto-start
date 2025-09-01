package ru.mtsbank.premium.Tests;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import ru.mtsbank.premium.pages.CodePage;
import ru.mtsbank.premium.pages.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();

    private final String PHONE_NUMBER = "9636125085";
    private final String[] PASSWORD_LIST = {"1", "2", "3","4"};
    private final String TEST_URL = "https://online.mtsdengi-test.mbrd.ru/";
    private final String DEV_URL = "https://online.mtsdengi-dev.mbrd.ru/";


    @BeforeClass(alwaysRun = true)
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setBrowserVersion("138");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverContainer.set(driver);
    }

    @BeforeClass(alwaysRun = true, dependsOnMethods = "setUp")
    public void auth() {
        driverContainer.get().get(TEST_URL);
        LoginPage loginPage = new LoginPage(driverContainer);
        CodePage codePage = loginPage.inputLogin(PHONE_NUMBER);
        codePage.inputCode(PASSWORD_LIST);
    }



//    @AfterClass
//    public static void tearDown() {
//        if(driverContainer.get() != null) {
//            driverContainer.get().close();
//        }
//    }




}
