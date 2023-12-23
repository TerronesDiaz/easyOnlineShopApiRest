package com.example.easyOnlineShop.easyOnlineShop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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
    @Column(name = "image_url", nullable = false)
    private String imageURL;

    @NonNull
    @Column(name = "image_name", nullable = false)
    private String imageName;

    @ManyToOne
    @JoinColumn(name = "product_id") // This is the name of the column in table 'Product_Image' that joins the column 'product_id' in 'Product'
    private Product product; // Inverse relationship with the entity Product.

}

