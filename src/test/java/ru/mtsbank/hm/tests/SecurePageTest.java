package ru.mtsbank.hm.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.hm.pages.HomePage;
import ru.mtsbank.hm.pages.LoginPage;
import ru.mtsbank.hm.pages.SecurePage;

public class SecurePageTest extends BaseTest {


    @Test(dataProvider = "credentials")
    public void testOpenSecurePage(String name, String password) {
        HomePage homePage = new HomePage(driverContainer);
        LoginPage loginPage = homePage.openLoginPageWithClickOnButton();
        SecurePage securePage = loginPage.login(name, password);

        Assert.assertEquals(securePage.getSecurePageUrl(), SECURE_URL);
    }

    @Test(dependsOnMethods = "testOpenSecurePage")
    public void testGetSecurePageTextInfo() {
        SecurePage securePage = new SecurePage(driverContainer);

        boolean isTrue = false;
        for (String i: SECURE_PAGE_TEXT) {
            if(securePage.getSecurePageTextInfo().contains(i)) {
                isTrue = true;
            }
        }
        Assert.assertTrue(isTrue);
    }

    @Test(dependsOnMethods = "testGetSecurePageTextInfo")
    public void testGetLogoutButtonText() {
        SecurePage securePage = new SecurePage(driverContainer);

        Assert.assertEquals(securePage.getLogoutButtonText(), LOGOUT_BUTTON_SP);
    }

    @Test(dependsOnMethods = "testGetLogoutButtonText")
    public void testIsLogoutButtonInteractive() {
        SecurePage securePage = new SecurePage(driverContainer);

        Assert.assertTrue(securePage.isLogoutButtonInteractive());
    }

    @Test(dependsOnMethods = "testIsLogoutButtonInteractive")
    public void testLogout() {
        SecurePage securePage = new SecurePage(driverContainer);
        LoginPage loginPage = securePage.logout();

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
