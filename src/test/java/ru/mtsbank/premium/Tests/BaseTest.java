package ru.mtsbank.premium.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import ru.mtsbank.premium.pages.CodePage;
import ru.mtsbank.premium.pages.LoginPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BaseTest {

    protected static InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();

    private static final String PHONE_NUMBER = "9636125085";
    private static final List<String> PASSWORD_LIST = Arrays.asList("1", "2", "3", "4");
    private static final String URL = "https://online.mtsdengi-test.mbrd.ru/";


    @BeforeClass(alwaysRun = true)
    public static void setUp() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverContainer.set(driver);
    }

    @BeforeClass(alwaysRun = true, dependsOnMethods = "setUp")
    public void auth() {
        driverContainer.get().get(URL);
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
