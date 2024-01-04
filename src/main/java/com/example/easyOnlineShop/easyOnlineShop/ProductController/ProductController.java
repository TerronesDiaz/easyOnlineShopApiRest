package com.example.easyOnlineShop.easyOnlineShop.ProductController;

import com.example.easyOnlineShop.easyOnlineShop.Dto.ProductDTO;
import com.example.easyOnlineShop.easyOnlineShop.Service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(path = "/listProducts")
    public ResponseEntity<List<ProductDTO>> listProducts() {
        List<ProductDTO> products = productService.findAllProducts();
        return ResponseEntity.ok(products);
    }

    @PutMapping(path = "/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        String response = productService.deleteProductById(id);
        return ResponseEntity.ok(response);
    }


}
