package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest{

    private static final String url = "https://online.mtsdengi-test.mbrd.ru/";

    @Test(description = "Тест проверки перехода на страницу после авторизации")
    public static void testAuth() {
        Assert.assertEquals(driverContainer.get().getCurrentUrl(), url);
    }
}
