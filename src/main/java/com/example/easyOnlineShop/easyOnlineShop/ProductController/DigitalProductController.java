package com.example.easyOnlineShop.easyOnlineShop.ProductController;

import com.example.easyOnlineShop.easyOnlineShop.Dto.DigitalProductDTO;
import com.example.easyOnlineShop.easyOnlineShop.Service.DigitalProductService;
import com.example.easyOnlineShop.easyOnlineShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/digitalProducts")
public class DigitalProductController extends ProductController {

    @Autowired
    private DigitalProductService digitalProductService;

    public DigitalProductController(ProductService productService) {
        super(productService);
    }

    @GetMapping(path = "/listDigitalProducts")
    public ResponseEntity<List<DigitalProductDTO>> listDigitalProducts() {
        List<DigitalProductDTO> products = digitalProductService.findAllDigitalProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping(path = "/saveDigitalProduct")
    public ResponseEntity<String> saveDigitalProduct(@RequestBody DigitalProductDTO digitalProductDTO) {
        String response = digitalProductService.addDigitalProduct(digitalProductDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/edit/{id}")
    public ResponseEntity<String> editDigitalProduct(@PathVariable long id, @RequestBody DigitalProductDTO digitalProductDTO) {
        digitalProductDTO.setProductId(id);
        String response = digitalProductService.editDigitalProduct(digitalProductDTO);
        return ResponseEntity.ok(response);
    }


}
