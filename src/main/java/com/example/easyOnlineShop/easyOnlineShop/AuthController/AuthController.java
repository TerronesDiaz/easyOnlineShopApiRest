package com.example.easyOnlineShop.easyOnlineShop.AuthController;

import com.example.easyOnlineShop.easyOnlineShop.Dto.AuthResponseDTO;
import com.example.easyOnlineShop.easyOnlineShop.Dto.LoginRequestDTO;
import com.example.easyOnlineShop.easyOnlineShop.Dto.RegisterRequestDTO;
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
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO request)
    {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<AuthResponseDTO>  register(@RequestBody RegisterRequestDTO request)
    {
        return ResponseEntity.ok(authService.register(request));
    }

}
