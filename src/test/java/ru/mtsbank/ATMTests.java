package ru.mtsbank;

import jdk.jfr.Name;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;


public class ATMTests {

    @BeforeClass
    @Name("Start tests")


    @Test
    public void getRatesTest() {
        String rates = "USD to EUR: 0.9\nUSD to RUB: 75";
        String result = ATM.getRates();
        Assert.assertEquals(result, rates);
    }

    @Test
    public void isValidActionTrueTest() {
        boolean isValidaction = false;
        int[] availableActions = {1, 2, 3, 4};
        for(int action: availableActions) {
            if(action == 1 || action == 2 || action == 3 || action == 4) {
                isValidaction = true;
            }
            Assert.assertTrue(isValidaction);
        }
    }

    @Test
    public void  isValidActionFalseTest() {
        boolean isValidAction = true;
        int[] availableActions = {-1,0,5};
        for(int action : availableActions) {
            if(action == -1 || action == 0 || action == 5) {
                isValidAction = false;
            }
            Assert.assertFalse(isValidAction);
        }
    }





}
