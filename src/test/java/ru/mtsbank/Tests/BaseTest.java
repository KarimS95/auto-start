package ru.mtsbank.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import ru.mtsbank.pages.LoginPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class BaseTest {

    protected static InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();

    private static final String phoneNumber = "9636125085";
    private static final List<String> passwordList = Arrays.asList("1", "2", "3", "4");
    private static final String url = "https://online.mtsdengi-test.mbrd.ru/";


    @BeforeClass(alwaysRun = true)
    public static void setUp() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        driverContainer.set(driver);
    }

    @BeforeClass(alwaysRun = true, dependsOnMethods = "setUp")
    public void login() throws InterruptedException {
        driverContainer.get().get(url);
        LoginPage loginPage = new LoginPage(driverContainer);

        loginPage.auth(phoneNumber, passwordList);
    }

//    @AfterClass
//    public static void tearDown() {
//        if(driverContainer.get() != null) {
//            driverContainer.get().close();
//        }
//    }

}
