package ru.mtsbank;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Helpers {
    public String fromFileToObjectToPrettyString(String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Object object = objectMapper.readValue(new File(path), Object.class);
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (IOException e) {
            throw new IOException("Ошибка конвертации объекта или обработки файла: ", e);
        }
    }
}