package com.example.easyOnlineShop.easyOnlineShop.Service;

import com.example.easyOnlineShop.easyOnlineShop.Dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAllProducts();
}
