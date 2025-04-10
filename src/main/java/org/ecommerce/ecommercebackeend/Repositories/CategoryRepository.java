package org.ecommerce.ecommercebackeend.Repositories;

import org.ecommerce.ecommercebackeend.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsByCategoryName(String categoryName);
}
