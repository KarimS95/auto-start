package ru.mtsbank;

import org.testng.Assert;
import org.testng.annotations.*;
import java.math.BigDecimal;
import static ru.mtsbank.Currency.*;

public class ATMTest {

    @Test
    public void testGetRates() {
        String rates = "USD to EUR: 0.9\nUSD to RUB: 75";
        String result = ATM.getRates();
        Assert.assertEquals(result, rates);
    }

    @Test
    public void testGetBalanceForUsd() {
       BigDecimal totalAmount = ATM.getBalance(USD);
       Assert.assertEquals(totalAmount, new BigDecimal(2000));
    }

    @Test
    public void testGetBalanceForEur() {
        BigDecimal totalAmount = ATM.getBalance(EUR);
        Assert.assertEquals(totalAmount, new BigDecimal(4000));
    }

    @Test
    public void testGetBalanceForRub() {
        BigDecimal totalAmount = ATM.getBalance(RUB);
        Assert.assertEquals(totalAmount, new BigDecimal(5000));
    }

    }

