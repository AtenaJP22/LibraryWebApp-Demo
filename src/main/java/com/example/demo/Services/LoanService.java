package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entities.Book;
import com.example.demo.Entities.DTO;
import com.example.demo.Entities.Loan;
import com.example.demo.Repositories.BookRepository;
import com.example.demo.Repositories.LoanRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(Long id) {
        return loanRepository.findById(id).orElse(null);
    }

    public Loan saveLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public void deleteLoan(Long id) {
        loanRepository.deleteById(id);
    }

    public List<Loan> getOverdueLoans() {
        return loanRepository.findAll().stream()
                .filter(Loan::isOverdue)
                .collect(Collectors.toList());
    }

    
	
    //public Loan borrowBook(Long bookId, Date borrowedDate, Date dueDate, String title, String author, String isbn, String genre, String cover_image_url, int publish_year) {
      //  Book book = bookRepository.findById(bookId).orElse(null);

        //if (book == null) {
          //  throw new IllegalArgumentException("Book not found with ID: " + bookId);
        //}

        //Loan loan = new Loan(book, borrowedDate, dueDate);

        //return loanRepository.save(loan);
    //}

    public Loan borrowBook(Long bookId, Date borrowedDate, Date dueDate) {
        // Fetch the book from the database
        Book book = bookRepository.findById(bookId).orElse(null);

        if (book == null) {
            throw new IllegalArgumentException("Book not found with ID: " + bookId);
        }

        // Create a new Loan object with book information and borrowing details
        Loan loan = new Loan();
        loan.setBook(book);
        
        loan.setBorrowedDate(borrowedDate);
        loan.setDueDate(dueDate);

        // Save the loan to the database
        return loanRepository.save(loan);
    }




    
    

    public List<Long> getBorrowedBookIds() {
        return loanRepository.findAll().stream()
                .map(loan -> loan.getBook().getId())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Object[]> getBorrowedBooksInfo() {
        return loanRepository.getBorrowedBooksInfo();
    }
    
    // public List<DTO> getBorrowedBooks() {
    //     return loanRepository.findAll().stream().map((Loan loan) -> {
    //         Book book = bookRepository.findById(loan.getId()).orElseThrow();
    //         return new DTO(
    //             book.getId(),
    //             book.getTitle(),
    //             book.getAuthor(),
    //             book.getIsbn(),
    //             book.getGenre(),
    //             book.getCoverImageUrl(),
    //             loan.getBorrowedDate(),
    //             loan.getDueDate()
    //         );
    //     }).collect(Collectors.toList());
    // }

    //new
    public List<DTO> getBorrowedBooks() {
        List<Loan> loans = loanRepository.findAll(); // Fetch all loans
        return loans.stream().map(loan -> {
           Book book = bookRepository.findById(loan.getBook().getId()).orElse(null);
           return DTO.fromEntities(book, loan);
        }).collect(Collectors.toList());
     }
  
}




