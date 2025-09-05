package ru.mtsbank.premium.web.mtsmoney.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import ru.mtsbank.premium.web.mtsmoney.constans.Constans;
import ru.mtsbank.premium.web.mtsmoney.pages.CodePage;
import ru.mtsbank.premium.web.mtsmoney.pages.LoginPage;

import java.time.Duration;

public class BaseTest {

    protected InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.setBrowserVersion("139");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverContainer.set(driver);
    }

    @BeforeClass(alwaysRun = true, dependsOnMethods = "setUp")
    public void auth() {
        driverContainer.get().get(Constans.TEST_URL.getStringValue());
        LoginPage loginPage = new LoginPage(driverContainer);
        CodePage codePage = loginPage.inputLogin(Constans.PHONE_NUMBER.getStringValue());
        codePage.inputCode(Constans.PASSWORD_LIST.getArrayStringValue());
    }



//    @AfterClass
//    public static void tearDown() {
//        if(driverContainer.get() != null) {
//            driverContainer.get().close();
//        }
//    }





}
