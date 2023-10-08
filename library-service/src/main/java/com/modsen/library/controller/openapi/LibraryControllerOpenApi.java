package com.modsen.library.controller.openapi;

import com.modsen.library.dto.BookIdDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface LibraryControllerOpenApi {

    @Operation(
            method = "POST",
            tags = "Library",
            description = "Add book to available books",
            responses = {
                    @ApiResponse(
                            responseCode = "200"
                    )
            }
    )
    ResponseEntity<?> addBook(BookIdDto bookIdDto);

    @Operation(
            method = "GET",
            tags = "Library",
            description = "Get available books ids with pagination",
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
                                                         "bookId": 1
                                                     },
                                                     {
                                                         "bookId": 2
                                                     },
                                                     {
                                                         "bookId": 3
                                                     },
                                                     {
                                                         "bookId": 4
                                                     },
                                                     {
                                                         "bookId": 5
                                                     },
                                                     {
                                                         "bookId": 6
                                                     }
                                                 ],
                                                 "pageable": {
                                                     "pageNumber": 0,
                                                     "pageSize": 20,
                                                     "sort": {
                                                         "empty": true,
                                                         "sorted": false,
                                                         "unsorted": true
                                                     },
                                                     "offset": 0,
                                                     "paged": true,
                                                     "unpaged": false
                                                 },
                                                 "last": true,
                                                 "totalPages": 1,
                                                 "totalElements": 6,
                                                 "size": 20,
                                                 "number": 0,
                                                 "sort": {
                                                     "empty": true,
                                                     "sorted": false,
                                                     "unsorted": true
                                                 },
                                                 "first": true,
                                                 "numberOfElements": 6,
                                                 "empty": false
                                             }
                                            """)
                            )
                    )
            }
    )
    ResponseEntity<Page<BookIdDto>> getAvailableBooks(Pageable pageable);
}
