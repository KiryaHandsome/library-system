package com.modsen.book.service.api;

import com.modsen.book.dto.BookCreate;
import com.modsen.book.dto.BookIdDto;
import com.modsen.book.dto.BookResponse;
import com.modsen.book.dto.BookUpdate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    BookResponse getById(int id);

    BookResponse getByISBN(String ISBN);

    Page<BookResponse> get(Pageable pageable);

    void deleteById(int id);

    BookResponse create(BookCreate request);

    BookResponse update(int id, BookUpdate request);

    Page<BookResponse> getBooksByIdList(Page<BookIdDto> dtoPage);
}
