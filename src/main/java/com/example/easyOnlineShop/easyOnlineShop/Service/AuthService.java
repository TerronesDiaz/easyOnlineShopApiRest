package com.example.easyOnlineShop.easyOnlineShop.Service;

import com.example.easyOnlineShop.easyOnlineShop.Dto.AuthResponse;
import com.example.easyOnlineShop.easyOnlineShop.Dto.LoginRequest;
import com.example.easyOnlineShop.easyOnlineShop.Dto.RegisterRequest;

public interface AuthService {
    AuthResponse login(LoginRequest request);

    AuthResponse register(RegisterRequest request);
}
