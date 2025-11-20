package ru.mtsbank;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class SuperGeneratorTest {

    @Test
    public void testSuperGeneratorTest() {

        Random random = new Random();
        List<Map<String, Object>> customers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Map<String, Object> mens = new HashMap<>();
            mens.put("Name", stringGenerator(random));
            mens.put("Surname", stringGenerator(random));
            mens.put("Age", intGenerator(random));

            Map<String, Object> womens = new HashMap<>();
            womens.put("Name", stringGenerator(random));
            womens.put("Surname", stringGenerator(random));
            womens.put("Age", intGenerator(random));

            Map<String, Object> humans = new HashMap<>();
            humans.put("mens", mens);
            humans.put("womens", womens);

            customers.add(humans);
        }

        Map<String, Object> report = new HashMap<>();
        report.put("customers", customers);
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("Karim Safin.json"), report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private int intGenerator(Random random) {
        int min = 18;
        int max = 30;
        return min + random.nextInt(max - min);
    }

    private String stringGenerator(Random random) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = "AaBbCcDdKkIiUuYyTtMmBbPp".toCharArray();

        for (int i = 0; i < chars.length; i ++) {
            stringBuilder.append(chars[random.nextInt(chars.length)]);
        }
        return stringBuilder.toString();
    }
}