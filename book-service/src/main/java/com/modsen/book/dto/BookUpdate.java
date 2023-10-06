package com.modsen.book.dto;

public record BookUpdate(
        String ISBN,
        String name,
        String genre,
        String description,
        String author
) {
}
