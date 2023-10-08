package com.modsen.library.controller;

import com.modsen.library.controller.openapi.LibraryControllerOpenApi;
import com.modsen.library.dto.BookIdDto;
import com.modsen.library.service.api.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/library")
@RequiredArgsConstructor
public class LibraryController implements LibraryControllerOpenApi {

    private final LibraryService libraryService;

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody BookIdDto bookIdDto) {
        libraryService.addBook(bookIdDto.bookId());
        return ResponseEntity
                .ok()
                .build();
    }

    @GetMapping
    public ResponseEntity<Page<BookIdDto>> getAvailableBooks(Pageable pageable) {
        Page<BookIdDto> response = libraryService.getAvailableBooks(pageable);
        return ResponseEntity.ok(response);
    }
}
