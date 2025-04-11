package org.ecommerce.ecommercebackeend.Service;


import org.ecommerce.ecommercebackeend.Controller.CategoryController;
import org.ecommerce.ecommercebackeend.DTO.ProductDTO;
import org.ecommerce.ecommercebackeend.Exceptions.ResourceNotFoundException;
import org.ecommerce.ecommercebackeend.Mapper.ProductMapper;
import org.ecommerce.ecommercebackeend.Model.Category;
import org.ecommerce.ecommercebackeend.Model.Product;
import org.ecommerce.ecommercebackeend.Repositories.CategoryRepository;
import org.ecommerce.ecommercebackeend.Repositories.ProductRepository;
import org.ecommerce.ecommercebackeend.iservice.iProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class ImplProductService implements iProductService {

    private final ProductRepository productRepository;
    private final CategoryController categoryController;
    private final ProductMapper productMapper;
    private final CategoryService categoryService;

    public ImplProductService(ProductRepository productRepository, CategoryController categoryController, ProductMapper productMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryController = categoryController;
        this.productMapper = productMapper;
        this.categoryService = categoryService;
    }
        @Override
    public Product createProduct(ProductDTO productDTO) {
        Optional<Product> product1 = productRepository.findById(productDTO.getProductID());
        if (product1.isPresent()){
            throw new RuntimeException("Not found");
        }

        Product product = productMapper.mappedFrom(productDTO);
        double specialPrice = (product.getPrice()) - ((product.getSpecialPrice() * 0.01) * (product.getPrice()));
        product.setPrice(specialPrice);
        return product;
    }
}
