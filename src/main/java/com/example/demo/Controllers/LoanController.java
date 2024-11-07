// Source code is decompiled from a .class file using FernFlower decompiler.
package com.example.demo.Controllers;

import com.example.demo.Entities.DTO;
import com.example.demo.Entities.Loan;
import com.example.demo.Services.LoanService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/loans"})
public class LoanController {
   @Autowired
   private LoanService loanService;

   public LoanController() {
   }

   @PostMapping({"/borrow"})
   public ResponseEntity<String> borrowBook(@RequestBody DTO request) {
      try {
         Long bookId = request.getBookId();
         Date borrowedDate = request.getBorrowedDate();
         Date dueDate = request.getDueDate();
         Loan loan = this.loanService.borrowBook(bookId, borrowedDate, dueDate);
         return loan != null ? ResponseEntity.ok().body("Book borrowed successfully") : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to borrow book");
      } catch (Exception var6) {
         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to borrow book: " + var6.getMessage());
      }
   }

   @GetMapping({"/borrowed"})
   public ResponseEntity<List<Long>> getBorrowedBooks() {
      List<Long> borrowedBookIds = this.loanService.getBorrowedBookIds();
      return ResponseEntity.ok(borrowedBookIds);
   }
}





