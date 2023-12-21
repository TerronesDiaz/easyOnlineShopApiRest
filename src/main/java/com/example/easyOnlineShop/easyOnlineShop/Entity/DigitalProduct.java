package com.example.easyOnlineShop.easyOnlineShop.Entity;

import com.example.easyOnlineShop.easyOnlineShop.Enums.CommissionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents a digital product in an e-commerce platform, extending the generic Product class.
 * It includes specific attributes for digital products, such as file size and format.
 * The class also handles commission information with two fields: commissionType and commissionValue.
 * The commissionType (FIXED or PERCENTAGE) is defined in the CommissionType enum and determines
 * how commissionValue is interpreted (as a fixed amount or a percentage).
 */

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("DIGITAL")
public class DigitalProduct extends Product {

    @Column(name = "file_size")
    private double fileSize;

    @Column(name = "format")
    private String format;

    @Enumerated(EnumType.STRING)
    @Column(name = "commission_type")
    private CommissionType commissionType;

    @Column(name = "commission_value")
    private double commissionValue;
}
