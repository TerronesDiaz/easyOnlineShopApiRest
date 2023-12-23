package com.example.easyOnlineShop.easyOnlineShop.Service.impl;

import com.example.easyOnlineShop.easyOnlineShop.Dto.ProductImageDTO;
import com.example.easyOnlineShop.easyOnlineShop.Entity.Product;
import com.example.easyOnlineShop.easyOnlineShop.Entity.ProductImage;
import com.example.easyOnlineShop.easyOnlineShop.Repo.ProductImageRepository;
import com.example.easyOnlineShop.easyOnlineShop.Repo.ProductRepository;
import com.example.easyOnlineShop.easyOnlineShop.Service.ProductImageService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductImageIMPL implements ProductImageService {

    private final ProductImageRepository productImageRepository;
    private final ProductRepository productRepository;

    public ProductImageIMPL(ProductImageRepository productImageRepository, ProductRepository productRepository) {
        this.productImageRepository = productImageRepository;
        this.productRepository = productRepository;
    }



    @Override
    public String addProductImage(ProductImageDTO productImageDTO) {
        // Convertir DTO a entidad, guardar y devolver un mensaje o el id del producto
        ProductImage entity = dtoToEntity(productImageDTO);
        productImageRepository.save(entity);
        return "Product Image added successfully with ID: " + entity.getImageId();
    }

    private ProductImage dtoToEntity(ProductImageDTO dto) {
        ProductImage entity = new ProductImage();
        entity.setImageURL(dto.getImageURL());
        entity.setImageName(dto.getImageName());

        // Check if a product ID is provided (using Long to allow null checks)
        if (dto.getProduct() != null && dto.getProduct().getProductId() != null) {
            // Find the product by ID and throw an exception if not found
            Product product = productRepository.findById(dto.getProduct().getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
            entity.setProduct(product); // Associate the product with the image
        }

        return entity;
    }



}
