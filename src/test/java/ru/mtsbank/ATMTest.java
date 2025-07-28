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

    @Test(dataProvider = "currencies")
    public void testGetBalance(Currency currency, BigDecimal expectedResult) {
        BigDecimal factResult = switch (currency) {
            case USD -> ATM.getBalance(USD);
            case EUR -> ATM.getBalance(EUR);
            case RUB -> ATM.getBalance(RUB);
        };
        Assert.assertEquals(factResult,expectedResult);
    }

    @Test(dataProvider = "currencyNominalsCount")
    public void testAmountValidator(Currency currency, int expectedResult) {
        int factResult = switch (currency) {
            case USD -> ATM.amountValidator(BigDecimal.valueOf(1000), USD);
            case EUR -> ATM.amountValidator(BigDecimal.valueOf(400), EUR);
            case RUB -> ATM.amountValidator(BigDecimal.valueOf(1250), RUB);
        };

        Assert.assertEquals(factResult, expectedResult);
    }


    @DataProvider(name = "currencies")
    public Object[][] currencies() {
        return new Object[][] {
                {USD, BigDecimal.valueOf(2000)},
                {EUR, BigDecimal.valueOf(4000)},
                {RUB, BigDecimal.valueOf(5000)}
        };
    }

    @DataProvider(name = "currencyNominalsCount")
    public Object[][] currencyNominalsCount() {
        return new Object[][]{
                {USD, 10},
                {EUR, 2},
                {RUB, 3}
        };
    }
}

