package com.modsen.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.modsen.book.dto.BookCreate;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.util.List;

@UtilityClass
public class JsonUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    public static List<BookCreate> getBooks() {
        InputStream resourceAsStream = JsonUtil.class.getResourceAsStream("/__files/books.json");
        return objectMapper.readValue(resourceAsStream, new TypeReference<>() {
        });
    }
}
