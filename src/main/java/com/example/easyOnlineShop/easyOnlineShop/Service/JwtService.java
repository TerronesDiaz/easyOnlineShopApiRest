package com.example.easyOnlineShop.easyOnlineShop.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    public String getToken(UserDetails newUser);

    String getUSernameFromToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);
}
