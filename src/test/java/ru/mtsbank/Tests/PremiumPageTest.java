package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.mtsbank.pages.PremiumPage;

public class PremiumPageTest extends BaseTest {

    private final static String premiumUrl = "https://online.mtsdengi-test.mbrd.ru/premium";

    @Test(description = "Тест открытия главной страницы Премиум")
    public void testOpenPremiumPage() {
        PremiumPage premiumPage = new PremiumPage(driverContainer);

        premiumPage.openPremiumPage();

        Assert.assertEquals(driverContainer.get().getCurrentUrl(), premiumUrl);
    }

}
