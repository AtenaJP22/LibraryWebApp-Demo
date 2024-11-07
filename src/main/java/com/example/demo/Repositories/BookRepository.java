package com.example.demo.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	List<Book> findByTitleContainingIgnoreCase(String title);
}
