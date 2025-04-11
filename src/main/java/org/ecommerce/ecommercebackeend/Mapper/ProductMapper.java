package org.ecommerce.ecommercebackeend.Mapper;

import org.ecommerce.ecommercebackeend.DTO.ProductDTO;
import org.ecommerce.ecommercebackeend.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO mappedTO(Product product){
        return new ProductDTO();
    }

    public Product mappedFrom(ProductDTO productDTO){
        return new Product();
    }
}
