package ru.mtsbank.hm.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();
    WebDriver driver;

    @BeforeClass
    protected void setUp() {
        this.driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://practice.expandtesting.com/");
        driverContainer.set(driver);
    }



//    @AfterClass
//    protected void tearDown() {
//        this.driver.quit();
//    }

    protected final int MAX_RETRIES = 5;
    protected final String HOME_PAGE_REG_PAGE_CARD_TEXT = "Test Register Page for Automation Testing Practice, a common use case for website authentication. You can use Playwright to automate these registration test scenarios";
    protected final String HOME_PAGE_FORGOT_PASS_PAGE_CARD_TEXT = "Example can be used for practicing the Forgot Password scenario in automated tests. An email will be sent to indicate password reset instructions";
    protected final String HOME_PAGE_BUTTON_TEXT = "Try it out";
    protected final String REGISTER_PAGE_URL = "https://practice.expandtesting.com/register";
    protected final String HOME_PAGE_URL = "https://practice.expandtesting.com/";
    protected final String LOGIN_PAGE_URL = "https://practice.expandtesting.com/login";
    protected final String[] FOOTER = {"[Practice Test Automation WebSite for Web UI and Rest API\nVersion: a9acc86c | Copyright Expand Testing 2025, Version: a9acc86c | Copyright Expand Testing 2025]"};
    protected final String BACK_BUTTON = "Home";
    protected final String[] REGISTER_PAGE_TEXT_INFO = {"[Test Register page for Automation Testing Practice, This Test Register page is designed for automation testing practice. Test various positive and negative register scenarios in a testing environment.\nYou can use this register page for practicing with Selenium or other tools like Playwright, Cypress, etc.]"};
    protected final String USERNAME_FIELD = "Username";
    protected final String PASSWORD_FIELD = "Password";
    protected final String PASSWORD_CONFIRM_FIELD = "Confirm Password";
    protected final String REGISTER_BUTTON = "Register";
    protected final String ALL_FIELDS_ARE_REQUIRED = "All fields are required.";
    protected final String SHORT_USERNAME = "Username must be at least 3 characters long.";
    protected final String LONG_USERNAME = "";
    protected final String WRONG_USERNAME = "Invalid username. Usernames can only contain lowercase letters, numbers, and single hyphens, must be between 3 and 39 characters, and cannot start or end with a hyphen.";
    protected final String SHORT_PASSWORD = "Password must be at least 4 characters long.";
    protected final String WRONG_PASSWORD = "An error occurred during registration. Please try again.";
    protected final String DIFFERENT_PASSWORDS = "Passwords do not match.";
    protected final String SAME_CREDS = "Username is already taken.";
    protected final String VALID_CREDS = "Successfully registered, you can log in now.";

    protected final String FORGOT_PASSWORD_PAGE_URL = "https://practice.expandtesting.com/forgot-password";
    protected final String RETRIEVE_PASSWORD_BUTTON = "Retrieve password";
    protected final String[] FORGOT_PASSWORD_PAGE_TEXT_INFO = {"[Dummy Forgot Password form page for Automation Testing Practice, Example can be used for practicing the Forgot Password scenario in automated tests. An email will be sent to indicate password reset instructions]"};
    protected final String[] INVALID_EMAIL = {"Your email is invalid!", "Please enter a valid email address."};
    protected final String[] VALID_EMAIL = {"An e-mail has been sent to you which explains how to reset your password."};
    protected final String EMAIL_FIELD = "E-mail";
    protected final String MESSAGE_AFTER_PASSWORD_RETRIEVE = "Password reset page for Automation Testing Practice";
}
