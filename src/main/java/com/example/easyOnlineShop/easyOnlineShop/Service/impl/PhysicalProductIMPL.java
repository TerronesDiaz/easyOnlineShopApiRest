package com.example.easyOnlineShop.easyOnlineShop.Service.impl;

import com.example.easyOnlineShop.easyOnlineShop.Dto.PhysicalProductDTO;
import com.example.easyOnlineShop.easyOnlineShop.Entity.PhysicalProduct;
import com.example.easyOnlineShop.easyOnlineShop.Entity.ProductImage;
import com.example.easyOnlineShop.easyOnlineShop.Enums.ProductStatus;
import com.example.easyOnlineShop.easyOnlineShop.Repo.PhysicalProductRepository;
import com.example.easyOnlineShop.easyOnlineShop.Repo.ProductImageRepository;
import com.example.easyOnlineShop.easyOnlineShop.Service.PhysicalProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PhysicalProductIMPL implements PhysicalProductService {

    private final PhysicalProductRepository physicalProductRepository;
    private final ProductImageRepository productImageRepository;

    @Autowired
    public PhysicalProductIMPL(PhysicalProductRepository physicalProductRepository,
                               ProductImageRepository productImageRepository) {
        this.physicalProductRepository = physicalProductRepository;
        this.productImageRepository = productImageRepository;
    }

    @Override
    public List<PhysicalProductDTO> findAllPhysicalProducts() {
        // Convert entities to DTOs and return the list
        return physicalProductRepository.findAll().stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String addPhysicalProduct(PhysicalProductDTO physicalProductDTO) {
        // Convert DTO to entity, save, and return a message or the product ID
        PhysicalProduct entity = dtoToEntity(physicalProductDTO);
        physicalProductRepository.save(entity);
        return "Product added successfully with ID: " + entity.getProductId();
    }

    @Override
    public String editPhysicalProduct(PhysicalProductDTO physicalProductDTO) {
        if (physicalProductDTO.getProductId() <= 0) { // Check if the ID is valid.
            throw new IllegalArgumentException("A valid ID for the physical product was not provided.");
        }

        Optional<PhysicalProduct> optionalProduct = physicalProductRepository.findById(physicalProductDTO.getProductId());
        if (optionalProduct.isPresent()) {
            PhysicalProduct existingProduct = optionalProduct.get();

            // Update fields inherited from ProductDTO
            if (physicalProductDTO.getProductName() != null && !physicalProductDTO.getProductName().isEmpty()) {
                existingProduct.setProductName(physicalProductDTO.getProductName());
            }
            if (physicalProductDTO.getProductStatus() != null) {
                existingProduct.setProductStatus(String.valueOf(physicalProductDTO.getProductStatus()));
            }

            // Update fields specific to PhysicalProductDTO
            if (physicalProductDTO.getWeight() != 0) {
                existingProduct.setWeight(physicalProductDTO.getWeight());
            }
            if (physicalProductDTO.getDimensions() != null && !physicalProductDTO.getDimensions().isEmpty()) {
                existingProduct.setDimensions(physicalProductDTO.getDimensions());
            }
            if (physicalProductDTO.getCost() != 0) {
                existingProduct.setCost(physicalProductDTO.getCost());
            }
            if (physicalProductDTO.getPrice() != 0) {
                existingProduct.setPrice(physicalProductDTO.getPrice());
            }
            if (physicalProductDTO.getStock() != 0) {
                existingProduct.setStock(physicalProductDTO.getStock());
            }
            existingProduct.setPerishable(physicalProductDTO.isPerishable());
            if (physicalProductDTO.getExpirationDate() != null) {
                existingProduct.setExpirationDate(physicalProductDTO.getExpirationDate());
            }
            // Save the changes to the database.
            physicalProductRepository.save(existingProduct);
            return "Physical product updated successfully with ID: " + existingProduct.getProductId();
        } else {
            throw new IllegalArgumentException("Physical product not found with ID: " + physicalProductDTO.getProductId());
        }
    }

    // Helper method to convert an entity to DTO
    private PhysicalProductDTO entityToDto(PhysicalProduct entity) {
        PhysicalProductDTO dto = new PhysicalProductDTO();
        dto.setProductId(entity.getProductId());
        dto.setProductName(entity.getProductName());
        dto.setProductStatus(ProductStatus.valueOf(entity.getProductStatus()));
        // Map images if present
        if (entity.getProductImages() != null) {
            List<Long> imageIds = entity.getProductImages().stream()
                    .map(ProductImage::getImageId)
                    .collect(Collectors.toList());
            dto.setProductImageIds(imageIds);
        }
        dto.setWeight(entity.getWeight());
        dto.setDimensions(entity.getDimensions());
        dto.setCost(entity.getCost());
        dto.setPrice(entity.getPrice());
        dto.setStock(entity.getStock());
        dto.setPerishable(entity.isPerishable());
        dto.setExpirationDate(entity.getExpirationDate());
        return dto;
    }

    // Helper method to convert a DTO to an entity
    private PhysicalProduct dtoToEntity(PhysicalProductDTO dto) {
        PhysicalProduct entity = new PhysicalProduct();
        entity.setProductName(dto.getProductName());
        entity.setProductStatus(dto.getProductStatus().name());
        entity.setWeight(dto.getWeight());
        entity.setDimensions(dto.getDimensions());
        entity.setCost(dto.getCost());
        entity.setPrice(dto.getPrice());
        entity.setStock(dto.getStock());
        entity.setPerishable(dto.isPerishable());
        entity.setExpirationDate(dto.getExpirationDate());

        if (dto.getProductImageIds() != null && !dto.getProductImageIds().isEmpty()) {
            List<ProductImage> productImages = dto.getProductImageIds().stream()
                    .map(productImageRepository::findById)
                    .filter(Optional::isPresent)
                    .map(optionalImage -> {
                        ProductImage image = optionalImage.get();
                        image.setProduct(entity); // Set the parent product for each image
                        return image;
                    })
                    .collect(Collectors.toList());
            entity.setProductImages(productImages);
        }

        return entity;
    }
}
