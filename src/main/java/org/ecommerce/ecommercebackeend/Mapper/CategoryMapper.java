package org.ecommerce.ecommercebackeend.Mapper;


import org.ecommerce.ecommercebackeend.DTO.CategoryDTO;
import org.ecommerce.ecommercebackeend.Model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {



//    public void mappedTO(Category category){
//        CategoryDTO categoryDTO = new CategoryDTO();
//        categoryDTO.setCategoryID(category.getCategoryID());
//        categoryDTO.setCategoryName(category.getCategoryName());
//
//    }


    public Category mappedFrom(CategoryDTO categoryDTO){
        Category category1 = new Category();
//        category1.setCategoryID(categoryDTO.getCategoryID());
        category1.setCategoryName(categoryDTO.getCategoryName());
        return category1;
    }
}
