package ru.mtsbank;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class TestDataGenerate {
    @Test
    public void testDataGenerate() throws IOException {
        Random random = new Random();

        // Основной контейнер для наших клиентов
        List<Map<String, Object>> customers = new ArrayList<>();

        // Генератор для фактической даты
        String factDate = "2025.10.20";

        // Генерируем 7000 записей
        for (int i = 0; i < 7000; i++) {
            // Генерация персональных данных
            Map<String, Object> personal = new HashMap<>();
            personal.put("surName", generateString(10, random));
            personal.put("name", generateString(10, random));
            personal.put("midName", generateString(10, random));
            personal.put("passport", generatePassport(random));
            personal.put("inn", generateINN(random));
            personal.put("phone", generatePhone(random));

            // Генерация счетов
            List<Map<String, Object>> accounts = new ArrayList<>();
            int numAccounts = random.nextInt(5) + 1;
            for (int j = 0; j < numAccounts; j++) {
                Map<String, Object> account = new HashMap<>();
                account.put("number", generateString(10, random));
                account.put("amount", random.nextInt(1000));
                accounts.add(account);
            }

            // Объединяем персональную информацию и счета в единый объект
            Map<String, Object> customer = new HashMap<>();
            customer.put("personal", personal);
            customer.put("accounts", accounts);

            // Добавляем запись в общий список
            customers.add(customer);
        }

        // Готовим финальный отчёт
        Map<String, Object> report = new HashMap<>();
        report.put("factDate", factDate);
        report.put("customers", customers);

        // Конвертация в JSON и запись в файл
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("report.json"), report);
    }

    // Вспомогательные методы для генерации данных
    private static String generateString(int length, Random random) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(chars[random.nextInt(chars.length)]);
        }
        return builder.toString();
    }

    private static String generatePassport(Random random) {
        long min = 1_000_000_000_000_000L;
        long max = 9_999_999_999_999_999L;
        return Long.toUnsignedString(min + random.nextLong(max - min));
    }

    private static String generateINN(Random random) {
        long min = 1_000_000_00L;
        long max = 9_999_999_999L;
        return Long.toUnsignedString(min + random.nextLong(max - min));
    }

    private static String generatePhone(Random random) {
        long min = 1_000_000_000_000_000L;
        long max = 9_999_999_999_999_999L;
        return Long.toUnsignedString(min + random.nextLong(max - min));
    }
    }