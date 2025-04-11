package org.ecommerce.ecommercebackeend.Repositories;

import jakarta.validation.constraints.NotBlank;
import org.ecommerce.ecommercebackeend.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {



    Category findByCategoryName(@NotBlank String categoryName);

    @Query("SELECT categoryName FROM Category WHERE categoryName = :categoryName")
    Optional<Category> findByName(@Param("categoryName") String categoryName);
}
