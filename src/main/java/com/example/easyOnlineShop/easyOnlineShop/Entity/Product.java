package com.example.easyOnlineShop.easyOnlineShop.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a product entity in an e-commerce application. Mapped to the 'Product' table in the database using JPA annotations.
 * Inherits common properties and behaviors for product types using a single-table inheritance strategy.
 * Lombok annotations are used to automatically generate boilerplate code like getters, setters, and constructors.
 * Key attributes include product ID, name, status, and a list of associated images.
 * The one-to-many relationship with ProductImage enables linking multiple images to a single product.
 */


@Entity
@Table(name="Product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;

    @NonNull
    @Column(name = "product_name")
    private String productName;

    @NonNull
    @Column(name="product_status")
    private String productStatus;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductImage> productImages = new ArrayList<>();
}
