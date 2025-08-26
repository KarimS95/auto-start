package ru.mtsbank.premium.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import ru.mtsbank.premium.pages.CodePage;
import ru.mtsbank.premium.pages.LoginPage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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
        WebDriver driver = new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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



    protected boolean checkIsTrue(String firstComparedValue, String[] secondComparedValue) {
        boolean isTrue = false;

        for (String i : secondComparedValue) {
            if (firstComparedValue.equals(i)) {
                isTrue = true;
            }
            break;
        }
        return isTrue;
    }






}
