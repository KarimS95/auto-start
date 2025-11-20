package ru.mtsbank.algorithms;

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

        if (array.length == 0 || array == null) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        for (int i = 0; i < array.length; i++) {
            sumValue += array[i];
            countValues++;
        }
        return sumValue / countValues;
    }

    //TO DO
    public int fibonacciNumbers(int[] numbersList) {
        int nextNumber = numbersList[0];

        for (int i = 0; i < numbersList.length; i++) {
            if (numbersList[i] != numbersList[0]) {
                    nextNumber += numbersList[i];
                    System.out.println("result Fib: " + nextNumber);

            }
        } //1,25,26,51
        return nextNumber;
    }
}