package com.modsen.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookCreate {
    @NotBlank
    @Pattern(regexp = "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$")
    private String ISBN;

    @Size(min = 2, max = 100)
    private String name;

    @Size(min = 2, max = 100)
    private String genre;

    @Size(min = 2, max = 100)
    private String description;

    @Size(min = 2, max = 100)
    private String author;
}
