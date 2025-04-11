package org.ecommerce.ecommercebackeend.Controller;


import jakarta.validation.Valid;
import org.ecommerce.ecommercebackeend.Config.AppConstants;
import org.ecommerce.ecommercebackeend.DTO.CategoryDTO;
import org.ecommerce.ecommercebackeend.Exceptions.ResourceNotFoundException;
import org.ecommerce.ecommercebackeend.Model.Category;
import org.ecommerce.ecommercebackeend.Service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/category")
public class CategoryController {


    private final CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;

    }

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize) {
        List<Category> categoryResponse = categoryService.getAllCategories(pageNumber, pageSize);
        if (categoryResponse.isEmpty()){
            throw new ResourceNotFoundException("No category found");
        }
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        Category savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long categoryId){
        String deletedCategory = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(deletedCategory, HttpStatus.OK);
    }


    @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,
                                                      @PathVariable Long categoryId){
        Category savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
    }

    @GetMapping("/public/{categoryName}")
    public ResponseEntity<Category> categoryName(@PathVariable String categoryName){
        Category category = categoryService.categoryName(categoryName);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
