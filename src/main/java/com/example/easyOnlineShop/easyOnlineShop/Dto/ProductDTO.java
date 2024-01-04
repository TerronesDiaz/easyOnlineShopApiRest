package com.example.easyOnlineShop.easyOnlineShop.Dto;

import com.example.easyOnlineShop.easyOnlineShop.Enums.ProductStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private long productId;
    private String productName;
    private String productType;
    private ProductStatus productStatus;
    private List<Long> productImageIds;
}
