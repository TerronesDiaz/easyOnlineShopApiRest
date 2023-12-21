package com.example.easyOnlineShop.easyOnlineShop.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
/**
 * Represents a physical product in an e-commerce application, extending the generic Product class.
 * It includes specific attributes relevant to physical items, such as weight, dimensions, cost, price, and stock level.
 * The 'isPerishable' field indicates whether the product is perishable,
 * and 'expirationDate' stores the expiry date for perishable items. For non-perishable items, 'expirationDate' is not applicable and can be left null.
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("PHYSICAL")
public class PhysicalProduct extends Product {

    @Column(name = "weight")
    private double weight;

    @Column(name = "dimensions")
    private String dimensions;

    @Column(name = "cost")
    private double cost;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "is_perishable")
    private boolean isPerishable;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;
}
