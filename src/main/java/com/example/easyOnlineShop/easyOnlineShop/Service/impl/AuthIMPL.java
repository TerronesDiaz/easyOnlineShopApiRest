package com.example.easyOnlineShop.easyOnlineShop.Service.impl;

import com.example.easyOnlineShop.easyOnlineShop.Dto.AuthResponseDTO;
import com.example.easyOnlineShop.easyOnlineShop.Dto.LoginRequestDTO;
import com.example.easyOnlineShop.easyOnlineShop.Dto.RegisterRequestDTO;
import com.example.easyOnlineShop.easyOnlineShop.Entity.User;
import com.example.easyOnlineShop.easyOnlineShop.Exceptions.CustomException;
import com.example.easyOnlineShop.easyOnlineShop.Repo.UserRepository;
import com.example.easyOnlineShop.easyOnlineShop.Service.AuthService;
import com.example.easyOnlineShop.easyOnlineShop.Service.JwtService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AuthIMPL implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthIMPL(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public AuthResponseDTO login(LoginRequestDTO request) {
        // First, search for the user in the database
        UserDetails user = userRepository.findByUserName(request.getUserName())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        try {
            // Attempt to authenticate the user
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
            );
        } catch (BadCredentialsException e) {
            // If authentication fails, throw a custom exception for incorrect password
            throw new CustomException("The password is incorrect, please try again", HttpStatus.UNAUTHORIZED);
        }

        // Generate the JWT token
        String token = jwtService.getToken(user);

        // Build and return the response
        return AuthResponseDTO.builder()
                .token(token)
                .build();
    }




    @Override
    public AuthResponseDTO register(RegisterRequestDTO request) {
        if (userRepository.findByUserName(request.getUserName()).isPresent()) {
            throw new CustomException("This user already exists, please log in.", HttpStatus.UNAUTHORIZED);
        }
        User newUser = User.builder()
                .userName(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .country(request.getCountry())
                .role(request.getRole())
                .build();
        userRepository.save(newUser);

        return AuthResponseDTO.builder()
                .token(jwtService.getToken(newUser))
                .build();
    }

}

