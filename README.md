# LibraryWebApp-Demo
An abstract library web application developed with  **Java** for backend logic, html and css for structure and styling, in SpringBoot (SpringToolSuite4) that represents basic functionalities from the users and the admin as well as performing CRUD operations on the books. An h2-database is utilized.  The desired books can be selected and borrowed by the user until a specified date. Sample data from https://openlibrary.org 

The Library Web System is a Spring Boot web application that performs CRUD operations on books. 
The desired books can be selected and borrowed by the user until a specified date. 
Two books have been borrowed by default and the due date is set to be one month after the date that the book was borrowed.

If the user borrows a book, the default due date would be two weeks after the day the book was borrowed. However, the due date can be adjusted by the user to any date after the borrow date. 

The application has two main sections: 

The Admin Section
The home page will ask for the role of the end-user. If Admin is selected, the admin will be able to view and search among all existing books, add a new book and edit or delete the existing books. All the changes applied will be applied to the database simultaneously.

The User Section
The user will be able to view and search among all the books, except the ones that have been deleted by the admin. The user will be able to borrow a book that has not already been borrowed and by default, the due date would be 14 days after the borrow date but the date can be modified by the user to any date after the borrow date. The user will also have the option to view the details all the books that have been borrowed apart from the borrow and due date.

General Walkthrough of the Project
Index Page :
The index page, often the main landing page of the website, could serve as a starting point for users:
Introduction to the library system and its functionalities.
Information about browsing and searching for books.
Links to navigate to specific sections like the admin page and user page.

In the home page, the end-user is asked to specify his/her role. If the admin button is chosen, the user would be redirected to the admin page, if the user button is chosen the user would be redirected to the user page (The procedure will be explained in Functionalities.)

User Page :
Viewing a list of available books (potentially with search and filter options).
Searching for books by title using a search bar.
Borrowing books: Users will be able to select books and initiate a borrowing process.
Viewing their borrowing history: This shows a list of borrowed books and their due dates.

Admin Page:
The admin page allows for managing the book collection:
Viewing a list of all books with details like title, author, ISBN, genre, and cover image.
Searching for books by title using a search bar.
Editing existing books by clicking an "Edit" button, which redirects to an edit page with the book ID.
Deleting books with confirmation prompts.
Adding new books through a dedicated form.

Adding Books:
A separate "Add Book" page provides a form for entering new book details, including title, author, ISBN, genre, publish year and cover image URL.
Upon form submission, the system sends a POST request to the server to add the new book.
According to the code, the fields title, author and isbn are required fields. The publish year is an integer so only numerical values will be accepted. Also, it must be in range [1900, 2024].

Editing Book Details:
An edit option for each book exists for the admin which provides a form for editing the existing book details, including title, author, ISBN, genre, publish year and cover image URL.
The system sends a PUT request to the server to edit the selected book.
The same constraints as adding a new book are applied when editing an existing book.

To add the in-memory h2 database, application.properties is modified accordingly:

spring.application.name=Library-Web-System
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:LibraryWebDatabase
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

In line 3, the database LibraryWebDatabase
 is created. In line 6, the password is set to default (i.e., empty). According to line 9, tables will be generated automatically when new data is added.


After running LibraryWebSystem1Application.java as a Spring Boot App, we can use the url  http://localhost:8080/h2-console to access the H2 database. After testing the connection, “Test Successful” should be displayed.

Database name is LibraryWebDatabase. After the successful connection, the database will be connected. 
The data is stored in two tables, TBL_BOOKS & TBL_LOANS.

TBL_BOOKS table stores the book details.


The TBL_LOANS table stores the book id of the borrowed book and the date the book was borrowed and the due date.

The tables are joined on BOOK_ID as shown in Schema.sql. All the sample data was retrieved from https://openlibrary.org/ 

Functionalities
Book Controller
The functions are retrieved from Book Service and the CRUD operations can be performed on the database according to the functions below. The additional search function is also added.

Book Entity
Here we have the constructor for book object and again, we map the two tables via book id and we implement getters and setters. isbn was changed to string as integer variable did not have as much capacity.

DTO.java
The Data Transfer object is used to fetch and store the data from both tables (tbl_books & tbl_loans) and store them all in the same object in order to form a collection. The purpose of this is explained below in Home Controller.

Home Controller
The Home Controller manages the necessary redirections to the proper html file. It also adds the DTO collection as an attribute to the model and redirects user to borrow.html in case the user wants to view the borrowed books.

Book Service
Book Service implements the necessary functions to interact with the database.




