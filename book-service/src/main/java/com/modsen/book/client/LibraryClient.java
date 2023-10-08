package com.modsen.book.client;

import com.modsen.book.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(
        name = "LibraryClient",
        url = "${external.library.url}"
)
public interface LibraryClient {

    @PostMapping
    ResponseEntity<?> addBook(BookIdDto bookIdDto);

    @GetMapping
    ResponseEntity<Page<BookIdDto>> getAvailableBooks(Pageable pageable);
}
