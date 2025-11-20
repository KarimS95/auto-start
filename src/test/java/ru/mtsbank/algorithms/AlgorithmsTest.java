package ru.mtsbank.algorithms;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.mtsbank.algorithms.Algorithms;

public class AlgorithmsTest {

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
        int actualResult = new Algorithms().maxIntArraysElement(intArrayList);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "avg", groups = "parallel")
    public void testIntArraysAvg(int[] array, int expectedResult) {
        int actualResult = new Algorithms().intArraysAvg(array);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "FibonacciNumbers")
    public void testFibonacciNumbers(int[] numbersList, int expectedResult) {
        int actualResult = new Algorithms().fibonacciNumbers(numbersList);

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

    @DataProvider(name = "FibonacciNumbers")
    public Object[][] object() {
        return new Object[][] {
                {new int[] {1,25,26,51}, 77}
        };
    }

}
