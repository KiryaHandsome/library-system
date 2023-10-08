package com.modsen.book.service.api;

import com.modsen.book.dto.LoginRequest;
import com.modsen.book.dto.TokenResponse;

public interface AuthService {

    TokenResponse login(LoginRequest request);
}
