package ru.mtsbank.hw.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    protected InheritableThreadLocal<WebDriver> driverContainer = new InheritableThreadLocal<>();
    WebDriver driver;
    ChromeOptions chromeOptions;

    @BeforeClass
    protected void setUp() {
        this.chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        this.driver = new ChromeDriver(chromeOptions);
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.get("https://practice.expandtesting.com/");
        driverContainer.set(driver);
    }



//    @AfterClass
//    protected void tearDown() {
//        this.driverContainer.get().quit();
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
    protected final String EMAIL_FIELD = "Your Email Address";
    protected final String EMAIL_FIELD_FP = "E-mail";
    protected final String MESSAGE_AFTER_PASSWORD_RETRIEVE = "Password reset page for Automation Testing Practice";

    protected final String OTP_PAGE_CARD_TEXT = "The example of a One Time Password (OTP) illustrates the process of authentication using an OTP code";
    protected final String OTP_PAGE_URL = "https://practice.expandtesting.com/otp-login";
    protected final String[] OTP_PAGE_TEXT_INFO = {"[OTP Login page for Automation Testing Practice, If you don't want to use a real email address, you can use the following information in your test scenarios:]"};
    protected final String LOGGED_IN = "You logged into a secure area!";
    protected final String INVALID_OTP_CODE = "The provided OTP code is incorrect. Please check your code and try again.";
    protected final String OTP_BUTTON_TEXT = "Send OTP Code";
    protected final String INVALID_EMAIL_OTP = "Please enter a valid email address.";
    protected final String SUCCESS_EMAIL_ALERT = "We've sent an OTP code to your email: practice@expandtesting.com";
    protected final String OTP_VERIFY_HEADER = "OTP Verification";
    protected final String SECURE_URL = "https://practice.expandtesting.com/secure";

    protected final String[] SECURE_PAGE_TEXT = {"[Secure Area page for Automation Testing Practice, Hi, practice!, Welcome to the Secure Area. When you are done click logout below.]"};
    protected final String LOGOUT_BUTTON_SP = "Logout";

    protected final String LOGIN_PAGE_CARD_HEADER = "Test Login page for Automation Testing Practice";
    protected final String[] LOGIN_PAGE_CARD_TEXT = {"This Test Login page is designed for automation testing practice. Test various positive and negative login scenarios in a testing environment.\nYou can use this login page for practicing with Selenium or other tools like Playwright, Cypress, etc.\nRegister here or Log in to the secure area with these credentials:\nUsername: practice\nPassword: SuperSecretPassword!"};
    protected final String LOGIN_BUTTON = "Login";
    protected final String INVALID_USERNAME = "Your username is invalid!";
    protected final String INVALID_PASSWORD = "Your password is invalid!";
    protected final String LOGGED_OUT = "You logged out of the secure area!";
    protected final String HOME_PAGE_LOGIN_PAGES_CARD_TEXT = "Test Login Page for Automation Testing Practice, a common use case for website authentication. You can use Playwright to automate these login test scenarios";


}
