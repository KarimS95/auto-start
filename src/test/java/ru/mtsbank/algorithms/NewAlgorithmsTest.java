package ru.mtsbank.algorithms;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewAlgorithmsTest {

    @Test(dataProvider = "getMinValue")
    public void testGetMinValue(int[] array, int expectedResult) {
        NewAlgorithms newAlgorithms = new NewAlgorithms();
        int actualResult = newAlgorithms.getMinValue(array);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dependsOnMethods = "testGetMinValue",expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "The array must not be empty")
    public void testGetMiValueWithException() {
        NewAlgorithms newAlgorithms = new NewAlgorithms();
        newAlgorithms.getMinValue(new int[]{});
    }


    @DataProvider(name = "getMinValue")
    public Object[][] getMinValue() {
        return new Object[][] {
                {new int[] {7,5,20,1,55}, 1}
        };
    }

}
