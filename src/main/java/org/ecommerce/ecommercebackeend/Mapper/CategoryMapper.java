package org.ecommerce.ecommercebackeend.Mapper;


import org.ecommerce.ecommercebackeend.DTO.CategoryDTO;
import org.ecommerce.ecommercebackeend.Model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {



    public static CategoryDTO mappedTO(CategoryDTO category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryID(category.getCategoryID());
        categoryDTO.setCategoryName(category.getCategoryName());

        return categoryDTO;
    }


    public Category mappedFrom(Category categoryDTO){
        Category category = new Category();
        category.setCategoryID(categoryDTO.getCategoryID());
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }
}
