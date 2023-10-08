package com.modsen.library.repository;

import com.modsen.library.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {
}
