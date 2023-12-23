package com.example.easyOnlineShop.easyOnlineShop.Dto;

import com.example.easyOnlineShop.easyOnlineShop.Enums.CommissionType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DigitalProductDTO extends ProductDTO {

    private double fileSize;
    private String format;
    private CommissionType commissionType;
    private double commissionValue;
}
