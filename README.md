# Library Management System Web API

This project is a Spring-based CRUD Web API that simulates a library management system
with an added LibraryService to track available books.

### Main Library System Functionality

1. **Get All Books**: Retrieve with pagination a list of all books in the library.
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
2. **Book Borrowing**: When a new book is added via the main service, a request is sent via Feign Client to the
   LibraryService, including the book's ID.
    - LibraryService stores information about:
        - The book (ID).
        - The time when the book was borrowed.
        - The time when the book needs to be returned.

### Technologies Used

The following technologies and frameworks have been utilized in this project:

1. **Spring boot**
2. **Spring Data Jpa**: ORM
3. **Spring Security**: Authentication with Bearer token
4. **Swagger**: For API documentation(you can access it at `/swagger-ui/index.html` endpoint of book service)

## How to Run the Project

Prerequisits

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

## Postman

You can also import [postman collection](postman/library-system-api.collection.json) and use prepared requests.
