package org.ecommerce.ecommercebackeend.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressID;

    @NotBlank
    @Size(min = 5, message = "Street name must be at least 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Building Name must be at least 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 5, message = "City name must be at least 5 characters")
    private String city;

    @NotBlank
    @Size(min = 5, message = "Country name must be at least 5 characters")
    private String country;

    @NotBlank
    @Size(min = 6, message = "Zip Code name must be at least 6 characters")
    private String zipCode;


    @ManyToMany(mappedBy = "address")
    private List<User> users = new ArrayList<>();

}
