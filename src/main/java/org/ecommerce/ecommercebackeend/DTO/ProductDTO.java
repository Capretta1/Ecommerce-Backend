package org.ecommerce.ecommercebackeend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long productID;
    private String productName;
    private String imageURL;
    private String description;
    private int quantity;
    private double price;
    private double discount;
    private double specialPrice;
}
