package ru.mtsbank.likeCoding;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AuthTest extends BaseTest{

    private static final String PHONE_NUMBER = "9636125085";
    private static final List<String> CODE_LIST = List.of("1","2","3","4");
    private static final List<String> URLS = List.of("https://online.mtsdengi-test.mbrd.ru/","https://online.mtsdengi-dev.mbrd.ru/");
    private static final List<String> WIDGET_NAMES = List.of("Private Banking", "Премиум");


    @Test
    public void testAuthorization() {
        LoginPage loginPage = new LoginPage(driverContainer);
        CodePage codePage = loginPage.inputLogin(PHONE_NUMBER);
        HomePage homePage = codePage.inputCode(CODE_LIST);

        String url = homePage.getHomePageUrl();
        String widgetName = homePage.getPremiumPrivateWidgetName();
        boolean isWidgetAvailable = homePage.checkPremiumPrivateWidget();

        boolean isUrlTrue = false;
        for (String i : URLS) {
            if (url.contains(i)) {
                isUrlTrue = true;
                break;
            }
        }

        boolean isWidgetTrue = false;
        for (String j : WIDGET_NAMES) {
            if (j.equals(widgetName)) {
                isWidgetTrue = true;
                break;
            }
        }

        Assert.assertTrue(isUrlTrue);
        Assert.assertTrue(isWidgetTrue);
        Assert.assertTrue(isWidgetAvailable);
    }


}
