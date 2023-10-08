# Library system

# Library Management System Web API

This is a CRUD (Create, Read, Update, Delete) Web API project developed using Spring. The purpose of this project is to
simulate a library management system where you can perform operations such as creating, updating, deleting, and
retrieving book information. Additionally, there is a LibraryService that keeps track of available books. Below you will
find instructions on how to run the project and details about its functionality.

## Description

This project focuses on creating a CRUD Web API for simulating a library system. It includes the ability to perform the
following operations:

### Main Library System Functionality

1. **Get All Books**: Retrieve a list of all books in the library.
2. **Get Book by Id**: Retrieve a specific book by its unique Id.
3. **Get Book by ISBN**: Retrieve a book by its ISBN.
4. **Add New Book**: Add a new book to the library.
5. **Update Book Information**: Modify the information of an existing book.
6. **Delete Book**: Remove a book from the library.

### Book Information

The following information is associated with each book:

1. ISBN
2. Title
3. Genre
4. Description
5. Author

### Additional Web API Functionality

In addition to the main functionality, this project also includes:

1. **LibraryService**: A separate service responsible for tracking available books.
2. **Book Borrowing**: When a new book is added via the main service, a request is sent via Feign Client to the LibraryService, including the book's ID.
    - LibraryService stores information about:
        - The book (ID).
        - The time when the book was borrowed.
        - The time when the book needs to be returned.

### Technologies Used

The following technologies and frameworks have been utilized in this project:

1. **Spring**: The core framework for building the Web API.
2. **Spring Boot**: For creating standalone, production-grade Spring-based applications.
3. **Spring MVC**: To handle HTTP requests.
4. **Spring Data Jpa**: To simplify work with entities in db.
5. **Relational Database Management Systems (RDBMS)**: PostgreSQL used as storage for services(separate db for each
   service).
6. **MapStruct**: Used for mapping data between objects.
7. **Spring Security & Bearer token authentication**: Ensures secure write operation access(create, update, delete) to the API.
8. **Swagger**: For API documentation and testing.

### Authentication, or any other RDBMS

To access the API, authentication via a Bearer Token is required to ensure security and access control.

### API Documentation

You can find detailed documentation for this API using Swagger. You can access the
API documentation at `/swagger-ui/index.html` endpoint of book service.

**Note**: OpenFeignClient has been used to communicate with the LibraryService.

## How to Run the Project

To run the project, follow these steps:

1. Clone the repository
   ```shell
   git clone git@github.com:KiryaHandsome/library-system.git
   ```
2. Go to directory with project and build it 
   
   ```shell
   ./gradlew build
   ```
3. Run services and databases in docker environment. Main service will expose to 8080 port.
   ```shell
   docker compose up
   ```
4. Authenticate at `/api/v1/auth/login` endpoint with credentials below and use api
   ```json
   {
    "username" : "username",
    "password" : "password"
   }
   ```

