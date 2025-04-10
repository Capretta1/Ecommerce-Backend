package org.ecommerce.ecommercebackeend.Service;



import org.ecommerce.ecommercebackeend.DTO.CategoryDTO;
import org.ecommerce.ecommercebackeend.Mapper.CategoryMapper;
import org.ecommerce.ecommercebackeend.Model.Category;
import org.ecommerce.ecommercebackeend.Repositories.CategoryRepository;
import org.ecommerce.ecommercebackeend.iservice.iCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@Service
public class CategoryService implements iCategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<CategoryDTO> getAllCategories(Integer pageNumber, Integer pageSize) {
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize);
        Page<Category> categoryPage = categoryRepository.findAll(pageDetails);
        List<Category> categories = categoryPage.getContent();
        if (categories.isEmpty()){
            throw new RuntimeException("No category added till now");
        }
        return categories.stream().map(categoryMapper::mappedTO).toList();
    }


    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.mappedFrom(categoryDTO);
        categoryRepository.save(category);
        return categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryID) {
        Category category = categoryRepository.findById(categoryID).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
         categoryRepository.delete(category);
        return "Category deleted successfully";
    }

    @Override
    public Category updateCategory(CategoryDTO categoryDTO, Long categoryID) {
       Category savedCategory = categoryRepository.findById(categoryID).
               orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
        savedCategory.setCategoryName(categoryDTO.getCategoryName());
        savedCategory = categoryRepository.save(savedCategory);
        return categoryMapper.mappedFrom(categoryDTO);
    }
}
