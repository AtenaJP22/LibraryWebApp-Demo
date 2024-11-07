package com.example.demo.Entities;


import java.util.Date;



public class DTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private String coverImageUrl;
    private int publishYear;
    private Date borrowedDate;
    private Date dueDate;

    //new
    // No-argument constructor
    public DTO() {
    }
    
    // Constructor
    public DTO(Long id, String title, String author, String isbn, String genre, String coverImageUrl, Date date, Date date2) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.genre = genre;
        this.coverImageUrl = coverImageUrl;
        this.setBorrowedDate(date);
        this.setDueDate(date2);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCoverImageUrl() {
        return coverImageUrl;
    }

    public void setCoverImageUrl(String coverImageUrl) {
        this.coverImageUrl = coverImageUrl;
    }

    

	public int getPublishYear() {
		return publishYear;
	}

	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}

	public Date getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(Date borrowedDate) {
		this.borrowedDate = borrowedDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	public Long getBookId() {
        return id;
    }

    public void setBookId(Long id) {
        this.id = id;
    }

    //New
    public static DTO fromEntities(Book book, Loan loan) {
        DTO dto = new DTO();
        dto.setBookId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(book.getAuthor());
        dto.setIsbn(book.getIsbn());
        dto.setGenre(book.getGenre());
        dto.setCoverImageUrl(book.getCoverImageUrl());
        dto.setBorrowedDate(loan.getBorrowedDate());
        dto.setDueDate(loan.getDueDate());
        return dto;
    }

    
}

