package ru.mtsbank.likeCoding;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private final String PHONE_NUMBER = "9110235461";
    private final String[] CODE_LIST = {"1","2","3","4"};
    private final String[] URLS = {"https://online.mtsdengi-dev.mbrd.ru/","https://online.mtsdengi-test.mbrd.ru/"};
    private final String[] WIDGET_NAMES = {"Private Banking","Премиум"};

    @Test
    public void testAuthentification() {
        LoginPage loginPage = new LoginPage(driverContainer);
        loginPage.inputLogin(PHONE_NUMBER);

        CodePage codePage = loginPage.clickOnNextButton();
        HomePage homePage = codePage.inputCode(CODE_LIST);

        String url = homePage.getHomePageUrl();
        boolean isUrlTrue = false;

        for (String i : URLS) {
            if (url.contains(i)) {
                isUrlTrue = true;
                break;
            }
        }

        String widgetName = homePage.getPremiumPrivateWidgetName();
        boolean isWidgetNameTrue = false;

        for (String i : WIDGET_NAMES) {
            if (widgetName.equals(i)) {
                isWidgetNameTrue = true;
                break;
            }
        }

        Assert.assertTrue(isUrlTrue);
        Assert.assertTrue(isWidgetNameTrue);
        Assert.assertTrue(homePage.checkPremiumPrivateWidget());
    }

}
