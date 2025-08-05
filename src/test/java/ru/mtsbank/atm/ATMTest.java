package ru.mtsbank.atm;

import org.testng.Assert;
import org.testng.annotations.*;

import java.math.BigDecimal;

import static ru.mtsbank.atm.Currency.*;

public class ATMTest {

    @Test(description = "Проверка получения курса валют")
    public void testGetRates() {
        String expectedResult = "USD to EUR: 0.9\nUSD to RUB: 75";
        String actualResult = ATM.getRates();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "currencies")
    public void testGetBalance(Currency currency, BigDecimal expectedResult) {
        BigDecimal actualResult = switch (currency) {
            case USD -> ATM.getBalance(USD);
            case EUR -> ATM.getBalance(EUR);
            case RUB -> ATM.getBalance(RUB);

        };
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "balance")
    public void testGetBalanceAfterAmountCalc(Currency currency, Integer action, BigDecimal expectedResult) {
        switch (currency) {

            case USD -> {
                switch (action) {
                    case 1 -> ATM.calcTotalAmount(new DollarBanknote(USD, 100), BigDecimal.valueOf(100), 1);
                    case 2 -> ATM.calcTotalAmount(new DollarBanknote(USD, 100), BigDecimal.valueOf(100), 2);
                }
            }
            case EUR -> {
                switch (action) {
                    case 1 -> ATM.calcTotalAmount(new EuroBanknote(EUR, 100), BigDecimal.valueOf(100), 1);
                    case 2 -> ATM.calcTotalAmount(new EuroBanknote(EUR, 100), BigDecimal.valueOf(100), 2);
                }
            }
            case RUB -> {
                switch (action) {
                    case 1 -> ATM.calcTotalAmount(new RubBanknote(RUB, 100), BigDecimal.valueOf(100), 1);
                    case 2 -> ATM.calcTotalAmount(new RubBanknote(RUB, 100), BigDecimal.valueOf(100), 2);
                }
            }
        }

        BigDecimal actualResult = switch (currency) {
            case USD -> ATM.getBalance(USD);
            case EUR -> ATM.getBalance(EUR);
            case RUB -> ATM.getBalance(RUB);
        };

        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "balance")
    public Object[][] balance() {
        return new Object[][]{
                {USD, 1, BigDecimal.valueOf(2100)},
                {USD, 2, BigDecimal.valueOf(2000)},
                {EUR, 1, BigDecimal.valueOf(4100)},
                {EUR, 2, BigDecimal.valueOf(4000)},
                {RUB, 1, BigDecimal.valueOf(5100)},
                {RUB, 2, BigDecimal.valueOf(5000)}
        };
    }

    @Test(dataProvider = "currencyNominalsCount")
    public void testAmountValidator(Currency currency, int expectedResult) {
        int actualResult = switch (currency) {
            case USD -> ATM.amountValidator(BigDecimal.valueOf(1000), USD);
            case EUR -> ATM.amountValidator(BigDecimal.valueOf(400), EUR);
            case RUB -> ATM.amountValidator(BigDecimal.valueOf(1250), RUB);
        };

        Assert.assertEquals(actualResult, expectedResult);
    }


    @DataProvider(name = "currencies")
    public Object[][] currencies() {
        return new Object[][]{
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

