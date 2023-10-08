package com.modsen.library.repository;

import com.modsen.library.model.BookLoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookLoanRepository extends JpaRepository<BookLoan, Integer> {

    @Query("""
    SELECT DISTINCT bl
    FROM BookLoan bl
    GROUP BY bl.id, bl.bookId, bl.dueTo, bl.tookAt
    HAVING bl.dueTo < CURRENT_TIMESTAMP
    """)
    Page<BookLoan> findAvailableBooks(Pageable pageable);
}
