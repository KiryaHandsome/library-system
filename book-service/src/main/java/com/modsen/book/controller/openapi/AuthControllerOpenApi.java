package com.modsen.book.controller.openapi;

import com.modsen.book.dto.BookResponse;
import com.modsen.book.dto.ErrorEntity;
import com.modsen.book.dto.LoginRequest;
import com.modsen.book.dto.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface AuthControllerOpenApi {

    @Operation(
            method = "POST",
            tags = "Auth",
            description = "Login and get access token",
            requestBody = @RequestBody(
                    content = @Content(
                            examples = @ExampleObject("""
                                                                        
                                    """)
                    )
            ),
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Returns access token",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BookResponse.class),
                                    examples = @ExampleObject("""
                                            """)
                            )
                    ),
                    @ApiResponse(
                            description = "Error when such ISBN already exists",
                            responseCode = "401",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorEntity.class),
                                    examples = @ExampleObject("""
                                                                                        
                                            """)
                            )
                    )
            }
    )
    ResponseEntity<TokenResponse> login(LoginRequest request);
}
