package com.example.easyOnlineShop.easyOnlineShop.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhysicalProductDTO extends ProductDTO {

    private double weight;
    private String dimensions;
    private double cost;
    private double price;
    private int stock;
    private boolean perishable;
    private LocalDate expirationDate;

}
