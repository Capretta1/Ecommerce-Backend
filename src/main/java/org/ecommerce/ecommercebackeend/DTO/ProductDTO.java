package org.ecommerce.ecommercebackeend.DTO;

import lombok.Data;

@Data
public class ProductDTO {

    private String productName;
    private String description;
    private int quantity;
    private double price;
    private double specialPrice;
}
