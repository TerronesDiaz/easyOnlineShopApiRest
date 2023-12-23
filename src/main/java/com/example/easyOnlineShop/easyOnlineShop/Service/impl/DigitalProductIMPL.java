package com.example.easyOnlineShop.easyOnlineShop.Service.impl;

import com.example.easyOnlineShop.easyOnlineShop.Dto.DigitalProductDTO;
import com.example.easyOnlineShop.easyOnlineShop.Entity.DigitalProduct;
import com.example.easyOnlineShop.easyOnlineShop.Entity.ProductImage;
import com.example.easyOnlineShop.easyOnlineShop.Enums.ProductStatus;
import com.example.easyOnlineShop.easyOnlineShop.Repo.DigitalProductRepository;
import com.example.easyOnlineShop.easyOnlineShop.Repo.ProductImageRepository;
import com.example.easyOnlineShop.easyOnlineShop.Service.DigitalProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class DigitalProductIMPL implements DigitalProductService {

    private final DigitalProductRepository digitalProductRepository;
    private final ProductImageRepository productImageRepository;

    // Inject the repository through the constructor
    public DigitalProductIMPL(DigitalProductRepository digitalProductRepository, ProductImageRepository productImageRepository) {
        this.digitalProductRepository = digitalProductRepository;
        this.productImageRepository = productImageRepository;
    }

    @Override
    public List<DigitalProductDTO> findAllDigitalProducts() {
        // Convert the entities to DTOs and return the list
        return digitalProductRepository.findAll().stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public String addDigitalProduct(DigitalProductDTO digitalProductDTO) {
        // Convert DTO to entity, save and return a message or the product id
        DigitalProduct entity = dtoToEntity(digitalProductDTO);
        digitalProductRepository.save(entity);
        return "Product added successfully with ID: " + entity.getProductId();
    }

    @Override
    public String editDigitalProduct(DigitalProductDTO digitalProductDTO) {
        if (digitalProductDTO.getProductId() <= 0) {
            throw new IllegalArgumentException("No ID of a Digital Product provided.");
        }

        Optional<DigitalProduct> optionalProduct = digitalProductRepository.findById(digitalProductDTO.getProductId());
        if (optionalProduct.isPresent()) {
            DigitalProduct existingProduct = optionalProduct.get();

            // Update fields inherited from ProductDTO
            if (digitalProductDTO.getProductName() != null && !digitalProductDTO.getProductName().isEmpty()) {
                existingProduct.setProductName(digitalProductDTO.getProductName());
            }
            if (digitalProductDTO.getProductStatus() != null) {
                existingProduct.setProductStatus(String.valueOf(digitalProductDTO.getProductStatus()));
            }
            if (digitalProductDTO.getProductImageIds() != null && !digitalProductDTO.getProductImageIds().isEmpty()) {
                List<ProductImage> productImages = digitalProductDTO.getProductImageIds().stream()
                        .map(this::findImageById)
                        .collect(Collectors.toList());
                existingProduct.setProductImages(productImages);
            }

            // Update specific DigitalProductDTO fields
            if (digitalProductDTO.getFileSize() != 0) {
                existingProduct.setFileSize(digitalProductDTO.getFileSize());
            }
            if (digitalProductDTO.getFormat() != null && !digitalProductDTO.getFormat().isEmpty()) {
                existingProduct.setFormat(digitalProductDTO.getFormat());
            }
            if (digitalProductDTO.getCommissionType() != null) {
                existingProduct.setCommissionType(digitalProductDTO.getCommissionType());
            }
            if (digitalProductDTO.getCommissionValue() != 0) {
                existingProduct.setCommissionValue(digitalProductDTO.getCommissionValue());
            }
            // Guarda los cambios en la base de datos.
            digitalProductRepository.save(existingProduct);
            return "Producto físico actualizado correctamente con ID: " + existingProduct.getProductId();
        } else {
            throw new IllegalArgumentException("Producto físico no encontrado con el ID: " + digitalProductDTO.getProductId());
        }
    }


    private DigitalProductDTO entityToDto(DigitalProduct entity) {
        DigitalProductDTO dto = new DigitalProductDTO();
        dto.setProductId(entity.getProductId());
        dto.setProductName(entity.getProductName());
        dto.setProductStatus(ProductStatus.valueOf(entity.getProductStatus()));
        // Convertir la lista de entidades de imagen a una lista de IDs de imagen
        dto.setProductImageIds(entity.getProductImages().stream()
                .map(ProductImage::getImageId)
                .collect(Collectors.toList()));
        dto.setFileSize(entity.getFileSize());
        dto.setFormat(entity.getFormat());
        dto.setCommissionType(entity.getCommissionType());
        dto.setCommissionValue(entity.getCommissionValue());
        return dto;
    }

    private DigitalProduct dtoToEntity(DigitalProductDTO dto) {
        DigitalProduct entity = new DigitalProduct();
        entity.setProductName(dto.getProductName());
        entity.setProductStatus(String.valueOf(dto.getProductStatus()));
        // Convertir IDs de imagen a entidades de imagen
        if (dto.getProductImageIds() != null) {
            List<ProductImage> images = dto.getProductImageIds().stream()
                    .map(this::findImageById)
                    .collect(Collectors.toList());
            entity.setProductImages(images);
        }
        entity.setFileSize(dto.getFileSize());
        entity.setFormat(dto.getFormat());
        entity.setCommissionType(dto.getCommissionType());
        entity.setCommissionValue(dto.getCommissionValue());
        return entity;
    }

    private ProductImage findImageById(Long id) {
        return productImageRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Image not found with ID: " + id));
    }




}
