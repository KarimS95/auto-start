package ru.mtsbank.atm;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static ru.mtsbank.atm.Currency.*;

public class BanknoteTest {

    @Test(dataProvider = "availableNominals")
    public void testGetAvailableNominals(Currency currency, String expectedResult) {
        Banknote dollarBanknote = new DollarBanknote(USD, 1);
        Banknote euroBanknote = new EuroBanknote(EUR, 5);
        Banknote rubBanknote = new RubBanknote(RUB, 50);

        String actualResult = switch (currency) {
            case USD -> Arrays.toString(dollarBanknote.getAvailableNominals());
            case EUR -> Arrays.toString(euroBanknote.getAvailableNominals());
            case RUB -> Arrays.toString(rubBanknote.getAvailableNominals());
        };

        Assert.assertEquals(actualResult, expectedResult);
    }

    @DataProvider(name = "availableNominals")
    public Object[] availableNominals() {
        return new Object[][]{
                {USD, "[1, 5, 10, 20, 50, 100]"},
                {EUR, "[5, 10, 20, 50, 100, 200]"},
                {RUB, "[50, 100, 200, 500, 1000, 5000]"}
        };
    }

}
