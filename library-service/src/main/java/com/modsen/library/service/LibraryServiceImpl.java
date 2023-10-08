package com.modsen.library.service;

import com.modsen.library.dto.BookIdDto;
import com.modsen.library.model.BookLoan;
import com.modsen.library.repository.BookLoanRepository;
import com.modsen.library.service.api.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements LibraryService {

    @Value("${loan.duration}")
    private int loanDuration;
    private final BookLoanRepository bookLoanRepository;

    @Override
    public void addBook(int bookId) {
        LocalDateTime now = LocalDateTime.now();
        BookLoan bookLoan = BookLoan.builder()
                .bookId(bookId)
                .tookAt(now)
                .dueTo(now.plusDays(loanDuration))
                .build();
        bookLoanRepository.save(bookLoan);
    }

    @Override
    public Page<BookIdDto> getAvailableBooks(Pageable pageable) {
        // todo: query only available books
        return bookLoanRepository
                .findAll(pageable)
                .map(bookLoan -> new BookIdDto(bookLoan.getBookId()));
    }
}
