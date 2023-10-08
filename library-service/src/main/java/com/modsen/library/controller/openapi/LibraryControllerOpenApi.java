package com.modsen.library.controller.openapi;

import com.modsen.library.dto.BookIdDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface LibraryControllerOpenApi {

    ResponseEntity<?> addBook(BookIdDto bookIdDto);

    ResponseEntity<Page<BookIdDto>> getAvailableBooks(Pageable pageable);
}
