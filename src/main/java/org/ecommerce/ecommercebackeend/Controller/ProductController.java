package org.ecommerce.ecommercebackeend.Controller;



import org.ecommerce.ecommercebackeend.DTO.ProductDTO;
import org.ecommerce.ecommercebackeend.Model.Product;
import org.ecommerce.ecommercebackeend.Service.ImplProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductController {


        private final ImplProductService productService;

        public ProductController(ImplProductService productService) {
            this.productService = productService;
        }

        @PostMapping("/admin/product")
        public ResponseEntity<Product> addProduct(@RequestBody ProductDTO product){

            Product productDTO = productService.createProduct(product);
            return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
        }
}


