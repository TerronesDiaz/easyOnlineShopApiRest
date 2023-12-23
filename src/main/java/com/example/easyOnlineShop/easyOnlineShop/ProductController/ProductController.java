package com.example.easyOnlineShop.easyOnlineShop.ProductController;

import com.example.easyOnlineShop.easyOnlineShop.Dto.ProductDTO;
import com.example.easyOnlineShop.easyOnlineShop.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    private ProductService productService;

    @GetMapping(path = "/listProducts")
    public ResponseEntity<List<ProductDTO>> listProducts() {
        List<ProductDTO> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

}
