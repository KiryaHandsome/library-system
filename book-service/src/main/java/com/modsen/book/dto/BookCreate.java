package com.modsen.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record BookCreate(
        @NotBlank
        @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$")
        String ISBN,

        @Size(min = 2, max = 100)
        String name,

        @Size(min = 2, max = 100)
        String genre,

        @Size(min = 2, max = 100)
        String description,

        @Size(min = 2, max = 100)
        String author
) {
}
