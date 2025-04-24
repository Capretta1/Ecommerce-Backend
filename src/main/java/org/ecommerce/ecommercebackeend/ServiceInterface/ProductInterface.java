package org.ecommerce.ecommercebackeend.ServiceInterface;

import org.ecommerce.ecommercebackeend.DTO.ProductDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProductInterface {
    ProductDTO addProduct(Long categoryId, ProductDTO product);

    List<ProductDTO> getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<ProductDTO>  searchByCategory(Long categoryId, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    List<ProductDTO>  searchProductByKeyword(String keyword, Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);

    ProductDTO updateProduct(Long productId, ProductDTO product);

    ProductDTO deleteProduct(Long productId);

    ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}
