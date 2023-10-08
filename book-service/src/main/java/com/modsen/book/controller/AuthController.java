package com.modsen.book.controller;

import com.modsen.book.controller.openapi.AuthControllerOpenApi;
import com.modsen.book.dto.LoginRequest;
import com.modsen.book.dto.TokenResponse;
import com.modsen.book.service.api.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController implements AuthControllerOpenApi {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@Valid @RequestBody LoginRequest request) {
        TokenResponse accessToken = authService.login(request);
        return ResponseEntity.ok(accessToken);
    }
}
