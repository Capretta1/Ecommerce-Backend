package org.ecommerce.ecommercebackeend.ServiceInterface;


import org.ecommerce.ecommercebackeend.DTO.CategoryDTO;
import org.ecommerce.ecommercebackeend.Model.Category;

import java.util.List;

public interface CategoryInterface {
    List<CategoryDTO> getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO deleteCategory(Long categoryId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
}
