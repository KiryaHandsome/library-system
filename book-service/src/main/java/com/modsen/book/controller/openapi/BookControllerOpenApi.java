package com.modsen.book.controller.openapi;

import com.modsen.book.dto.BookCreate;
import com.modsen.book.dto.BookResponse;
import com.modsen.book.dto.BookUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface BookControllerOpenApi {

    ResponseEntity<BookResponse> getBookById(@PathVariable Integer id);

    ResponseEntity<Page<BookResponse>> getBooks(Pageable pageable);

    ResponseEntity<String> deleteBookById(@PathVariable Integer id);

    ResponseEntity<BookResponse> createBook(BookCreate request);

    ResponseEntity<BookResponse> updateBook(@PathVariable Integer id, BookUpdate request);
}
