package com.modsen.book.repository;

import com.modsen.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    Optional<Book> findByISBN(String ISBN);

    List<Book> findBooksByIdIn(List<Integer> idList);
}
