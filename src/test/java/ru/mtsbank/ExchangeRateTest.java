package ru.mtsbank;

import org.testng.Assert;
import org.testng.annotations.*;
import java.math.BigDecimal;
import static ru.mtsbank.Currency.*;

public class ExchangeRateTest {

    @Test
    public void testNoNeedForConvert() {
        BigDecimal covertUsdResult = ExchangeRate.convert(BigDecimal.valueOf(100),USD,USD);
        BigDecimal covertEurResult = ExchangeRate.convert(BigDecimal.valueOf(100),EUR,EUR);
        BigDecimal covertRubResult = ExchangeRate.convert(BigDecimal.valueOf(100),RUB,RUB);
        Assert.assertEquals(covertUsdResult, BigDecimal.valueOf(100));
        Assert.assertEquals(covertEurResult, BigDecimal.valueOf(100));
        Assert.assertEquals(covertRubResult, BigDecimal.valueOf(100));
    }

    @Test
    public void testUsdToEurConvert() {
        BigDecimal convertResult = ExchangeRate.convert(BigDecimal.valueOf(100),USD,EUR);
        Assert.assertEquals(convertResult,BigDecimal.valueOf(90.0));
    }

    @Test
    public void testUsdToRubConvert() {
        BigDecimal convertResult = ExchangeRate.convert(BigDecimal.valueOf(100),USD,RUB);
        Assert.assertEquals(convertResult, BigDecimal.valueOf(7500));
    }

    @Test
    public void testEurToUsdConvert() {
        BigDecimal convertResult = ExchangeRate.convert(BigDecimal.valueOf(100),EUR,USD);
        Assert.assertEquals(convertResult, BigDecimal.valueOf(111));
    }

    @Test
    public void testRubToUsdConvert() {
        BigDecimal convertResult = ExchangeRate.convert(BigDecimal.valueOf(5000),RUB,USD);
        Assert.assertEquals(convertResult, BigDecimal.valueOf(67));
    }

}
