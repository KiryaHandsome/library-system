package com.modsen.book.service.api;

public interface TokenService {

    String generateToken(String username);

    boolean validateToken(String token);

    String extractUsername(String token);
}
