package ru.mtsbank.likeCoding.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static ru.mtsbank.likeCoding.data.TestData.ERROR_LOGIN_TEXT;

public class AuthTest extends BaseTest {

    @Test
    public void testAuth() {

        boolean isTrue = actualResult.contains(ERROR_LOGIN_TEXT);

        Assert.assertTrue(isTrue);
    }
}
