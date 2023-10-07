package com.modsen.book.controller.openapi;

import com.modsen.book.dto.BookCreate;
import com.modsen.book.dto.BookResponse;
import com.modsen.book.dto.BookUpdate;
import com.modsen.book.dto.ErrorEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface BookControllerOpenApi {

    @Operation(
            method = "GET",
            tags = "Book",
            description = "Get book by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BookResponse.class),
                                    examples = @ExampleObject("""
                                            {
                                                "id": 1,
                                                "ISBN": "9780451524935",
                                                "name": "1984",
                                                "genre": "Fiction",
                                                "description": "A dystopian novel by George Orwell",
                                                "author": "George Orwell"
                                            }
                                            """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorEntity.class),
                                    examples = @ExampleObject("""
                                            {
                                                "message": "Book not found. id = 10"
                                            }
                                            """)
                            )
                    )
            }
    )
    ResponseEntity<BookResponse> getBookById(Integer id);

    @Operation(
            method = "GET",
            tags = "Book",
            description = "Get books with pagination",
            parameters = {
                    @Parameter(name = "page", description = "Page number", example = "0"),
                    @Parameter(name = "size", description = "page size", example = "10"),
                    @Parameter(name = "sort", description = "Sorting by field", example = "id")
            },
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Pageable.class),
                                    examples = @ExampleObject("""
                                            {
                                                "content": [
                                                    {
                                                        "id": 1,
                                                        "ISBN": "9780451524935",
                                                        "name": "1984",
                                                        "genre": "Fiction",
                                                        "description": "A dystopian novel by George Orwell",
                                                        "author": "George Orwell"
                                                    },
                                                    {
                                                        "id": 3,
                                                        "ISBN": "9780316969683",
                                                        "name": "The Da Vinci Code",
                                                        "genre": "Mystery",
                                                        "description": "A mystery thriller by Dan Brown",
                                                        "author": "Dan Brown"
                                                    },
                                                    {
                                                        "id": 4,
                                                        "ISBN": "9780062315007",
                                                        "name": "Sapiens: A Brief History of Humankind",
                                                        "genre": "Non-Fiction",
                                                        "description": "A history book by Yuval Noah Harari",
                                                        "author": "Yuval Noah Harari"
                                                    }
                                                ],
                                                "pageable": {
                                                    "pageNumber": 0,
                                                    "pageSize": 3,
                                                    "sort": {
                                                        "sorted": false,
                                                        "empty": true,
                                                        "unsorted": true
                                                    },
                                                    "offset": 0,
                                                    "paged": true,
                                                    "unpaged": false
                                                },
                                                "last": false,
                                                "totalPages": 3,
                                                "totalElements": 7,
                                                "first": true,
                                                "size": 3,
                                                "number": 0,
                                                "sort": {
                                                    "sorted": false,
                                                    "empty": true,
                                                    "unsorted": true
                                                },
                                                "numberOfElements": 3,
                                                "empty": false
                                            }
                                            """)
                            )
                    )
            }
    )
    ResponseEntity<Page<BookResponse>> getBooks(Pageable pageable);


    @Operation(
            method = "DELETE",
            tags = "Book",
            description = "Delete book by id",
            responses = {
                    @ApiResponse(
                            responseCode = "204"
                    )
            }
    )
    ResponseEntity<Void> deleteBookById(Integer id);

    @Operation(
            method = "POST",
            tags = "Book",
            description = "Create book",
            requestBody = @RequestBody(
                    content = @Content(
                            examples = @ExampleObject("""
                                    {
                                      "ISBN": "978-1234567893",
                                      "name": "Sample Book",
                                      "genre": "Fiction",
                                      "description": "A sample book description.",
                                      "author": "John Doe"
                                    }
                                    """)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BookResponse.class),
                                    examples = @ExampleObject("""
                                            {
                                                "id": 11,
                                                "ISBN": "978-1234567893",
                                                "name": "Sample Book",
                                                "genre": "Fiction",
                                                "description": "A sample book description.",
                                                "author": "John Doe"
                                            }
                                            """)
                            )
                    ),
                    @ApiResponse(
                            description = "Error when such ISBN already exists",
                            responseCode = "400",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorEntity.class),
                                    examples = @ExampleObject("""
                                            {
                                                "message": "Book with such ISBN already exists, ISBN = 978-1234567893"
                                            }
                                            """)
                            )
                    )
            }
    )
    ResponseEntity<BookResponse> createBook(BookCreate request);

    @Operation(
            method = "PUT",
            tags = "Book",
            description = "Full update of book by id",
            requestBody = @RequestBody(
                    content = @Content(
                            examples = @ExampleObject("""
                                    {
                                      "ISBN": "978-1234567893",
                                      "name": "Sample Book",
                                      "genre": "Fiction",
                                      "description": "A sample book description.",
                                      "author": "John Doe"
                                    }
                                    """)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BookResponse.class),
                                    examples = @ExampleObject("""
                                            {
                                                "id": 11,
                                                "ISBN": "978-1234567893",
                                                "name": "Sample Book",
                                                "genre": "Fiction",
                                                "description": "A sample book description.",
                                                "author": "John Doe"
                                            }
                                            """)
                            )
                    ),
                    @ApiResponse(
                            description = "Error when book with such id not found",
                            responseCode = "404",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorEntity.class),
                                    examples = @ExampleObject("""
                                            {
                                                "message": "Book not found. id = 20"
                                            }
                                            """)
                            )
                    )
            }
    )
    ResponseEntity<BookResponse> updateBook(Integer id, BookUpdate request);
}
