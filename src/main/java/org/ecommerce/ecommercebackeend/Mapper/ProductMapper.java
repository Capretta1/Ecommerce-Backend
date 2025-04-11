package org.ecommerce.ecommercebackeend.Mapper;

import org.ecommerce.ecommercebackeend.DTO.ProductDTO;
import org.ecommerce.ecommercebackeend.Model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public ProductDTO mappedTO(Product product){
       ProductDTO productDTO = new ProductDTO();
       productDTO.setProductID(product.getProductID());
       productDTO.setProductName(product.getProductName());
       productDTO.setImageURL(product.getImageURL());
       productDTO.setDescription(product.getDescription());
       productDTO.setQuantity(productDTO.getQuantity());
       productDTO.setPrice(product.getPrice());
       productDTO.setDiscount(product.getDiscount());
       productDTO.setSpecialPrice(product.getSpecialPrice());
       return productDTO;
    }

    public Product mappedFrom(ProductDTO productDTO){
       Product product = new Product();
       product.setProductID(productDTO.getProductID());
       product.setProductName(productDTO.getProductName());
       product.setImageURL(productDTO.getImageURL());
       product.setDescription(productDTO.getDescription());
       product.setQuantity(productDTO.getQuantity());
       product.setPrice(productDTO.getPrice());
       product.setDiscount(productDTO.getDiscount());
       product.setSpecialPrice(productDTO.getSpecialPrice());
       return product;
    }
}
