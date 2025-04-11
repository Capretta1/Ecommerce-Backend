package org.ecommerce.ecommercebackeend.iservice;

import org.ecommerce.ecommercebackeend.DTO.CategoryDTO;
import org.ecommerce.ecommercebackeend.Model.Category;

import java.util.List;

public interface iCategoryService {

    List<Category> getAllCategories(Integer pageNumber, Integer pageSize);
    Category createCategory(CategoryDTO categoryDTO);
    String deleteCategory(Long categoryID);
    Category updateCategory(CategoryDTO categoryDTO, Long categoryID);
}
