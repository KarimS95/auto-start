package ru.mtsbank.hm.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.HomePage;
import ru.mtsbank.hm.pages.LoginPage;
import ru.mtsbank.hm.pages.SecurePage;

public class SecurePageTest extends BaseTest {


    @Test(dataProvider = "credentials")
    public void testLogout(String username, String password) {
        HomePage homePage = new HomePage(driverContainer);
        LoginPage loginPage = homePage.openLoginPageWithClickOnButton();
        SecurePage securePage = loginPage.login(username, password);
        securePage.logout();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(), LOGIN_PAGE_URL);
        Assert.assertEquals(loginPage.alert(), LOGGED_OUT);
    }


    @DataProvider(name = "credentials")
    public Object[][] getCredentials() {
        return new Object[][] {
                {"practice","SuperSecretPassword!"}
        };
    }

}
