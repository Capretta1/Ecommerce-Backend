package org.ecommerce.ecommercebackeend.Repositories;


import org.ecommerce.ecommercebackeend.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT productName FROM Product WHERE productName = :productName")
    Product findProductName(@Param("productName") String name);
}
