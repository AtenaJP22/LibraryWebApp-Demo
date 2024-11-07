package com.example.demo.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    // Method to check if a book is already borrowed
    @Query("SELECT COUNT(l) > 0 FROM Loan l WHERE l.book.id = :bookId")
    boolean isBookBorrowed(@Param("bookId") Long bookId);
    
    @Query("SELECT b.title, b.author, b.isbn, b.genre, b.coverImageUrl, l.borrowedDate, l.dueDate FROM Book b INNER JOIN Loan l ON b.id = l.book.id")
    List<Object[]> getBorrowedBooksInfo();
    
    
}




