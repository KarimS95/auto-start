package ru.mtsbank.premium.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTest extends BaseTest{

    private static final String[] URL = {"https://online.mtsdengi-test.mbrd.ru/"};

    @Test
    public void testAuth() {
        boolean found = false;
        for(String iterator : URL) {
            if(driverContainer.get().getCurrentUrl().contains(iterator)) {
                found = true;
            }
        }
        Assert.assertTrue(found);
    }

}
