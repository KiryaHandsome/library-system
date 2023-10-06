package com.modsen.book.dto;

public record BookResponse(
        Integer id,
        String ISBN,
        String name,
        String genre,
        String description,
        String author
) {}
