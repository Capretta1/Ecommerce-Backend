package org.ecommerce.ecommercebackeend.Model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity(name = "Product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long productID;

    @NotEmpty(message = "Name cannot be Empty")
    @Size(min = 5)
    private String productName;

    @NotEmpty(message = "Description cannot be Empty")
    @Size(min = 20)
    private String description;

    @NotEmpty(message = "Enter the amount of quantities")
    private int quantity;

    private double price;
    private double specialPrice;

    @ManyToOne
    @JoinColumn(name = "category_ID")
    private Category category;


}
