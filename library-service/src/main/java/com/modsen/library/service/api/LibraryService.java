package com.modsen.library.service.api;


import com.modsen.library.dto.BookIdDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LibraryService {

    void addBook(int bookId);

    Page<BookIdDto> getAvailableBooks(Pageable pageable);
}
