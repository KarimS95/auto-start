package ru.mtsbank.Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import ru.mtsbank.pages.*;

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
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driverContainer.set(driver);
    }

    @BeforeClass(alwaysRun = true, dependsOnMethods = "setUp")
    public void auth() throws InterruptedException {
        driverContainer.get().get(url);
        LoginPage loginPage = new LoginPage(driverContainer);
        CodePage codePage = new CodePage(driverContainer);

        loginPage.inputLogin(phoneNumber);
        codePage.inputCode(passwordList);
    }



//    @AfterClass
//    public static void tearDown() {
//        if(driverContainer.get() != null) {
//            driverContainer.get().close();
//        }
//    }

    protected void returnBack() {
        WebDriverWait backButtonWait = new WebDriverWait(driverContainer.get(), Duration.ofSeconds(30));
        backButtonWait.until(ExpectedConditions.visibilityOf(backButton)).click();
    }

    @FindBy(xpath = "//button[@data-testid='back-button']")//ok
    private WebElement backButton;

}
