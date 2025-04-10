package org.ecommerce.ecommercebackeend.Controller;


import org.ecommerce.ecommercebackeend.Config.AppConstants;
import org.ecommerce.ecommercebackeend.DTO.CategoryDTO;
import org.ecommerce.ecommercebackeend.Model.Category;
import org.ecommerce.ecommercebackeend.Repositories.CategoryRepository;
import org.ecommerce.ecommercebackeend.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Category")
public class CategoryController {


    private final CategoryService categoryService;
    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryService categoryService, CategoryRepository categoryRepository) {
        this.categoryService = categoryService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/api/public/getCategories")
    public ResponseEntity<List<Category>> getAllCategory(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false)Integer pageNumber ,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize)
    {
        List<Category> category = categoryService.getAllCategories(pageNumber, pageSize);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }


    @PostMapping("/api/admin/createCategory")
    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
        Category newCategory = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
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
    public ResponseEntity<?> updateCategory(@RequestBody Category category, @PathVariable Long categoryID){
        try {
            categoryService.updateCategory(category, categoryID);
            return new ResponseEntity<>("updated", HttpStatus.OK);
        }catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getHeaders(), e.getStatusCode());
        }
    }
}
