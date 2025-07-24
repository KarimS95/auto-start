package ru.mtsbank;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;


public class ATMTests {

    @Test(testName =  "Start tests")
    public void getRatesTest() {
        String rates = "USD to EUR: 0.9\nUSD to RUB: 75";
        String result = ATM.getRates();
        Assert.assertEquals(result, rates);
    }




    }

