package com.modsen.book.controller;

import com.modsen.book.client.LibraryClient;
import com.modsen.book.controller.openapi.BookControllerOpenApi;
import com.modsen.book.dto.BookCreate;
import com.modsen.book.dto.BookIdDto;
import com.modsen.book.dto.BookResponse;
import com.modsen.book.dto.BookUpdate;
import com.modsen.book.service.api.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.URI;

@Controller
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController implements BookControllerOpenApi {

    private final BookService bookService;
    private final LibraryClient libraryClient;

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(@PathVariable Integer id) {
        BookResponse response = bookService.getById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<BookResponse>> getBooks(Pageable pageable) {
        Page<BookResponse> response = bookService.get(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/by-isbn")
    public ResponseEntity<BookResponse> getBookByISBN(@RequestParam(name = "isbn") String ISBN) {
        BookResponse response = bookService.getByISBN(ISBN);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Integer id) {
        bookService.deleteById(id);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PostMapping
    public ResponseEntity<BookResponse> createBook(@Valid @RequestBody BookCreate request) {
        BookResponse response = bookService.create(request);
        libraryClient.addBook(new BookIdDto(response.id()));
        return ResponseEntity
                .created(URI.create("/api/v1/books/" + response.id()))
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(@PathVariable Integer id, @Valid @RequestBody BookUpdate request) {
        BookResponse response = bookService.update(id, request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/available")
    public ResponseEntity<Page<BookResponse>> getAvailableBooks(Pageable pageable) {
        Page<BookIdDto> booksIdPage = libraryClient.getAvailableBooks(pageable).getBody();
        Page<BookResponse> response = bookService.getBooksByIdList(booksIdPage);
        return ResponseEntity.ok(response);
    }
}
