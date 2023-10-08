package com.modsen.book.service;

import com.modsen.book.dto.LoginRequest;
import com.modsen.book.dto.TokenResponse;
import com.modsen.book.exception.InvalidPasswordException;
import com.modsen.book.exception.UserNotFoundException;
import com.modsen.book.model.User;
import com.modsen.book.repository.UserRepository;
import com.modsen.book.service.api.AuthService;
import com.modsen.book.service.api.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    @Override
    @Transactional(readOnly = true)
    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.username())
                .orElseThrow(
                        () -> new UserNotFoundException("user with such username not found. username = " + request.username())
                );
        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new InvalidPasswordException("Provided password is not valid.");
        }

        String token = tokenService.generateToken(user.getUsername());
        return new TokenResponse(token);
    }
}