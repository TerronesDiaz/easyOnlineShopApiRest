package com.example.easyOnlineShop.easyOnlineShop.ProductController;

import com.example.easyOnlineShop.easyOnlineShop.Dto.PhysicalProductDTO;
import com.example.easyOnlineShop.easyOnlineShop.Service.PhysicalProductService;
import com.example.easyOnlineShop.easyOnlineShop.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/physicalProducts")
public class PhysicalProductController extends ProductController {

    @Autowired
    private PhysicalProductService physicalProductService;

    public PhysicalProductController(ProductService productService) {
        super(productService);
    }

    @GetMapping(path = "/listPhysicalProducts")
    public ResponseEntity<List<PhysicalProductDTO>> listPhysicalProducts() {
        List<PhysicalProductDTO> products = physicalProductService.findAllPhysicalProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping(path = "/savePhysicalProduct")
    public ResponseEntity<String> savePhysicalProduct(@RequestBody PhysicalProductDTO physicalProductDTO) {
        String response = physicalProductService.addPhysicalProduct(physicalProductDTO);
        return ResponseEntity.ok(response);
    }

    @PutMapping(path = "/edit/{id}")
    public ResponseEntity<String> editPhysicalProduct(@PathVariable long id, @RequestBody PhysicalProductDTO physicalProductDTO) {
        physicalProductDTO.setProductId(id);
        String response = physicalProductService.editPhysicalProduct(physicalProductDTO);
        return ResponseEntity.ok(response);
    }


}
