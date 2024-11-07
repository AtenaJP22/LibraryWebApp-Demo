CREATE TABLE IF NOT EXISTS tbl_books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    isbn VARCHAR(255),
    genre VARCHAR(255),
    cover_image_url VARCHAR(255),
    publish_year INTEGER
);

CREATE TABLE IF NOT EXISTS tbl_loans (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    book_id BIGINT NOT NULL,
    borrowed_date DATE NOT NULL,
    due_date DATE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES tbl_books(id)
);
