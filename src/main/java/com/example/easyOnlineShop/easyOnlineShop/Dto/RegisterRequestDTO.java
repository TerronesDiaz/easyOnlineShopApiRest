package com.example.easyOnlineShop.easyOnlineShop.Dto;

import com.example.easyOnlineShop.easyOnlineShop.Enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequestDTO {
    String userName;
    String password;
    String firstName;
    String lastName;
    String country;
    Role role;
}
