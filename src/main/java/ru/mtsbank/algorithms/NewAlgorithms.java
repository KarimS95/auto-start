package ru.mtsbank.algorithms;

public class NewAlgorithms {

    public int getMinValue(int[] array) {

        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("The array must not be empty");
        }

        int minValue = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}
