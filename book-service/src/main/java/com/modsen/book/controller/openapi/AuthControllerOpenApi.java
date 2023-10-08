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
                            description = "Valid username and password. Returns access token",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = BookResponse.class),
                                    examples = @ExampleObject("""
                                            {
                                                "accessToken": "eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE2OTY4MDY5MTksImV4cCI6MTY5NjgwODcxOSwiaXNzIjoibW9kc2VuIiwic3ViIjoidXNlcm5hbWUifQ.i-h8-pCV3D2M4d6WNNY_av74vl3yoO6ULKs7gEw8GeehXQaEeDtjEY5no453DpQP"
                                            }
                                            """)
                            )
                    ),
                    @ApiResponse(
                            responseCode = "401",
                            description = "Password or username not valid",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = ErrorEntity.class),
                                    examples = {
                                            @ExampleObject("""
                                                    {
                                                        "message": "Provided password is not valid."
                                                    }
                                                    """),
                                            @ExampleObject("""
                                                    {
                                                        "message": "user with such username not found. username = username2"
                                                    }
                                                    """)
                                    }
                            )
                    )

            }
    )
    ResponseEntity<TokenResponse> login(LoginRequest request);
}
