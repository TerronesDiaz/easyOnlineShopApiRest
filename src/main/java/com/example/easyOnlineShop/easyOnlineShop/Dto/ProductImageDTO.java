package com.example.easyOnlineShop.easyOnlineShop.Dto;

import com.example.easyOnlineShop.easyOnlineShop.Entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductImageDTO {

    private long imageId;
    private String imageURL;
    private String imageName;
    private Product product;
}
