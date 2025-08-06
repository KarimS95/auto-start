package ru.mtsbank.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest{

    private static final String url = "https://online.mtsdengi-test.mbrd.ru/";

    @Test
    public void testInputLogin() {

    }

    @Test(dependsOnMethods = "testInputLogin")
    public void testInputCode() {
        Assert.assertEquals(driverContainer.get().getCurrentUrl(), url);
    }
}
