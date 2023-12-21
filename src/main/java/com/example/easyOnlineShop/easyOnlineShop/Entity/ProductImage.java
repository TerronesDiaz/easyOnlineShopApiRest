package com.example.easyOnlineShop.easyOnlineShop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an image associated with a product in an e-commerce application. Mapped to the 'Product_Image' table using JPA annotations.
 * Includes auto-generated boilerplate code such as getters, setters, and constructors through Lombok annotations.
 * Contains an image ID as its primary key and the actual image data stored as a byte array.
 * The '@Lob' annotation indicates that 'imageData' is a large object, suitable for storing binary data like images.
 */

@Entity
@Table(name = "Product_Image")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private long imageId;

    @Lob
    @Column(name = "image_data", nullable = false)
    private byte[] imageData;
}

