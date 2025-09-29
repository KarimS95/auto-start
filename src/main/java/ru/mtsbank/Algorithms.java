package ru.mtsbank;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Algorithms {

    public String reverseString(String string) {
        String reversedString = "";
        for (int i = string.length() - 1; i >= 0; i--) {
            reversedString += string.charAt(i);
        }
        return reversedString;
    }

    public int intArraySum(int[] intArr) {
        int sum = intArr[0];
        for (int i = 1; i < intArr.length; i++) {
            sum += intArr[i];
        }
        return sum;
    }

    public int minIntArraysElement(int[] intArr) {
        int minValue = intArr[0];
        for (int i = 1; i < intArr.length; i++) {
            if (intArr[i] < minValue) {
                minValue = intArr[i];
            }
        }
        return minValue;
    }

    public int maxIntArraysElement(int[] intArr) {
        int maxValue = intArr[0];

        for(int i = 0; i < intArr.length; i++) {
            if (intArr[i] > maxValue) {
                maxValue = intArr[i];
            }
        }
        return maxValue;
    }

    public int intArraysAvg(int[] array) {
        int sumValue = 0;
        int countValues = 0;

        for (int i = 0; i < array.length; i++) {
            sumValue += array[i];
            countValues++;
        }
        return sumValue / countValues;
    }


    @Test(dataProvider = "reverse", groups = "parallel")
    public void testReverseString(String string, String expectedResult) {
        String actualString = new Algorithms().reverseString(string);
        System.out.println("reversed string: " + actualString);

        Assert.assertEquals(actualString,expectedResult);
    }

    @Test(dataProvider = "intArrSum", groups = "parallel")
    public void testIntArraySum(int[] intArrayList, int expectedResult) {
        int actualResult = new Algorithms().intArraySum(intArrayList);
        System.out.println("sum: " + actualResult);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "minIntArraysElement", groups = "parallel")
    public void testMinIntArraysElement(int[] intArrayList, int expectedResult) {
        int actualResult = new Algorithms().minIntArraysElement(intArrayList);
        System.out.println("min: " + actualResult);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "maxIntArraysElement", groups = "parallel")
    public void testMaxIntArraysElement(int[] intArrayList, int expectedResult) {
        int actualResult = maxIntArraysElement(intArrayList);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "avg", groups = "parallel")
    public void testIntArraysAvg(int[] array, int expectedResult) {
        int actualResult = intArraysAvg(array);

        Assert.assertEquals(actualResult, expectedResult);
    }


    @DataProvider(name = "reverse")
    public Object[][] reverse() {
        return new Object[][] {
                {"Test", "tseT"}
        };
    }

    @DataProvider(name = "intArrSum")
    public Object[][] intArrSum() {
        return new Object[][] {
                {new int[]{100,150,250,425}, 925}
        };
        }

    @DataProvider(name = "minIntArraysElement")
    public Object[][] minIntArraysElement() {
        return new Object[][] {
                {new int[]{24,25,525,10,15,100}, 10}
        };
    }

    @DataProvider(name = "maxIntArraysElement")
    public Object[][] maxIntArraysElement() {
        return new Object[][] {
                {new int[] {25,5,50,15}, 50}
        };
    }

    @DataProvider(name = "avg")
    public Object[][] avg() {
        return new Object[][] {
                {new int[] {1,25,250}, 92}
        };
    }
}