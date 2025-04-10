package org.ecommerce.ecommercebackeend.Controller;


import org.ecommerce.ecommercebackeend.DTO.CategoryDTO;
import org.ecommerce.ecommercebackeend.Model.Category;
import org.ecommerce.ecommercebackeend.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/getCategories")
    public List<Category> getAllCategory(){
        return categoryService.getAllCategories();
    }


    @PostMapping("/api/admin/createCategory")
    public String createCategory(@RequestBody Category categoryDTO){
        categoryService.createCategory(categoryDTO);
        return "Category added successfully";
    }

    @DeleteMapping("/api/admin/deleteCategory/{categoryID}")
    public ResponseEntity<String>deleteCategory(@PathVariable Long categoryID){
        try {
            String status = categoryService.deleteCategory(categoryID);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getHeaders(), e.getStatusCode());
        }
    }

    @PutMapping("/api/admin/updateCategory/{categoryID}")
    public ResponseEntity<String> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryID){
        try {
            categoryService.updateCategory(categoryDTO, categoryID);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getHeaders(), e.getStatusCode());
        }
    }
}
