package com.modsen.book.service.api;

import com.modsen.book.dto.BookCreate;
import com.modsen.book.dto.BookResponse;
import com.modsen.book.dto.BookUpdate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {

    BookResponse getById(int id);

    List<BookResponse> get(Pageable pageable);

    void deleteById(int id);

    BookResponse create(BookCreate request);

    BookResponse update(int id, BookUpdate request);
}
