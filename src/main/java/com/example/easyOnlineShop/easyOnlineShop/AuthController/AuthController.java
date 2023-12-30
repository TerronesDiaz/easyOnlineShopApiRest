package com.example.easyOnlineShop.easyOnlineShop.AuthController;

import com.example.easyOnlineShop.easyOnlineShop.Dto.AuthResponse;
import com.example.easyOnlineShop.easyOnlineShop.Dto.LoginRequest;
import com.example.easyOnlineShop.easyOnlineShop.Dto.RegisterRequest;
import com.example.easyOnlineShop.easyOnlineShop.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public/v1")
public class AuthController {

    private final AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponse>  register(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.register(request));
    }

}
