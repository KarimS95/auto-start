package ru.mtsbank;

import org.testng.annotations.Test;

public class myTest {

    @Test
    public void testMy() {
        String str = "Test";
        String reversedStr = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            char[] chars = str.toCharArray();
            reversedStr += chars[i];
        }
        System.out.println(reversedStr);
    }
}