package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest{

    private static final String[] URL = {"https://online.mtsdengi-test.mbrd.ru/","https://online.mtsdengi-dev.mbrd.ru/"};

    @Test
    public void testAuth() {
        boolean found = false;
        for(String i : URL) {
            if(driverContainer.get().getCurrentUrl().equals(i)) {
                found = true;
                break;
            }
        }
        Assert.assertTrue(found);
    }

}
