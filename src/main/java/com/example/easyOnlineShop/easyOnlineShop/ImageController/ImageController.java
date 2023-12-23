package com.example.easyOnlineShop.easyOnlineShop.ImageController;

import com.example.easyOnlineShop.easyOnlineShop.Dto.ProductImageDTO;
import com.example.easyOnlineShop.easyOnlineShop.Service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/productImage")
@CrossOrigin
public class ImageController {

    @Autowired
    private ProductImageService imageService;

    @PostMapping(path = "/saveProductImage")
    public ResponseEntity<String> saveProductImage(@RequestBody ProductImageDTO productImageDTO) {
        String response = imageService.addProductImage(productImageDTO);
        return ResponseEntity.ok(response);
    }

}
