package com.example.easyOnlineShop.easyOnlineShop.Service;

import com.example.easyOnlineShop.easyOnlineShop.Dto.AuthResponseDTO;
import com.example.easyOnlineShop.easyOnlineShop.Dto.LoginRequestDTO;
import com.example.easyOnlineShop.easyOnlineShop.Dto.RegisterRequestDTO;

public interface AuthService {
    AuthResponseDTO login(LoginRequestDTO request);

    AuthResponseDTO register(RegisterRequestDTO request);
}
