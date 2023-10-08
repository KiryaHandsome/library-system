package com.modsen.book.service;

import com.modsen.book.dto.BookCreate;
import com.modsen.book.dto.BookIdDto;
import com.modsen.book.dto.BookResponse;
import com.modsen.book.dto.BookUpdate;
import com.modsen.book.exception.BookNotFoundException;
import com.modsen.book.exception.BookWithSuchISBNAlreadyExistsException;
import com.modsen.book.mapper.BookMapper;
import com.modsen.book.model.Book;
import com.modsen.book.repository.BookRepository;
import com.modsen.book.service.api.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    @Override
    @Transactional(readOnly = true)
    public BookResponse getById(int id) {
        return bookRepository.findById(id)
                .map(bookMapper::bookToResponse)
                .orElseThrow(() -> new BookNotFoundException("Book not found. id = " + id));
    }

    @Override
    public BookResponse getByISBN(String ISBN) {
        return bookRepository.findByISBN(ISBN)
                .map(bookMapper::bookToResponse)
                .orElseThrow(() -> new BookNotFoundException("Book not found. ISBN = " + ISBN));
    }

    @Override
    @Transactional(readOnly = true)
    public Page<BookResponse> get(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .map(bookMapper::bookToResponse);
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookResponse create(BookCreate request) {
        ifBookWithSuchISBNExistsThrow(request.ISBN());
        Book book = bookMapper.createToBook(request);
        bookRepository.save(book);
        return bookMapper.bookToResponse(book);
    }

    @Override
    public BookResponse update(int id, BookUpdate request) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found. id = " + id));
        if (!book.getISBN().equals(request.ISBN())) {
            ifBookWithSuchISBNExistsThrow(request.ISBN());
        }
        bookMapper.updateBookFromDto(request, book);
        bookRepository.save(book);
        return bookMapper.bookToResponse(book);
    }

    @Override
    public Page<BookResponse> getBooksByIdList(Page<BookIdDto> dtoPage) {
        List<Integer> idList = dtoPage.get()
                .map(BookIdDto::bookId)
                .toList();
        Map<Integer, BookResponse> booksByIdMap = bookRepository.findBooksByIdIn(idList)
                .stream()
                .map(bookMapper::bookToResponse)
                .collect(Collectors.toMap(BookResponse::id, br -> br));
        return dtoPage.map(dto -> booksByIdMap.get(dto.bookId()));
    }

    private void ifBookWithSuchISBNExistsThrow(String ISBN) {
        bookRepository.findByISBN(ISBN)
                .ifPresent(b -> {
                    throw new BookWithSuchISBNAlreadyExistsException(
                            "Book with such ISBN already exists, ISBN = " + ISBN
                    );
                });
    }
}
