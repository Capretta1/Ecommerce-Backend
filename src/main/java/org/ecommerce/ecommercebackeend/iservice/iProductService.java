package org.ecommerce.ecommercebackeend.iservice;


import org.ecommerce.ecommercebackeend.DTO.ProductDTO;
import org.ecommerce.ecommercebackeend.Model.Product;

public interface iProductService {

    Product createProduct(ProductDTO productDTO);
}
