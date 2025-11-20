package ru.mtsbank;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.*;
import java.util.*;

public class GeneratorTest {

    @Test
    public void testGeneratorTest() {
        Random random = new Random();

        List<Map<String, Object>> customers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Map<String, Object> mans = new HashMap<>();
            mans.put("Name", stringGenerator(random));
            mans.put("Surname", stringGenerator(random));
            mans.put("Age", intGenerator(random));

            Map<String, Object> womens = new HashMap<>();
            womens.put("Name", stringGenerator(random));
            womens.put("Surname", stringGenerator(random));
            womens.put("Age", intGenerator(random));

            Map<String, Object> humans = new HashMap<>();
            humans.put("mans", mans);
            humans.put("womens", womens);

            customers.add(humans);
        }

        Map<String, Object> report = new HashMap<>();
        report.put("customers", customers);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("Karim_Safin.json"), report);
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
        char[] chars = "AaBbDdCcEeKkMmNnPp".toCharArray();

        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[random.nextInt(chars.length)]);
        }
        return stringBuilder.toString();
    }
}
