package org.ecommerce.ecommercebackeend.Service;




import org.ecommerce.ecommercebackeend.DTO.CategoryDTO;
import org.ecommerce.ecommercebackeend.Exceptions.ResourceNotFoundException;
import org.ecommerce.ecommercebackeend.Mapper.CategoryMapper;
import org.ecommerce.ecommercebackeend.Model.Category;
import org.ecommerce.ecommercebackeend.Repositories.CategoryRepository;
import org.ecommerce.ecommercebackeend.iservice.iCategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService implements iCategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public List<Category>getAllCategories(Integer pageNumber, Integer pageSize) {
        Pageable pageDetails = PageRequest.of(pageNumber, pageSize);
        Page<Category> categoryPage = categoryRepository.findAll(pageDetails);

        List<Category> categories = categoryPage.getContent();
        if (categories.isEmpty())
            throw new ResourceNotFoundException("No category created till now.");
        return categories.stream().toList();
    }

    @Override
    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepository.findByCategoryName(categoryDTO.getCategoryName());
        if (!(category == null)){
            throw new RuntimeException("Category already exist");
        }
        Category category1 = categoryMapper.mappedFrom(categoryDTO);
        return categoryRepository.save(category1);
        }



    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found" + categoryId));

        categoryRepository.delete(category);
        return "Category Deleted successfully";
    }



    @Override
    public Category updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Optional<Category> savedCategory = categoryRepository.findById(categoryId);
                if (savedCategory.isEmpty()){
                    throw new RuntimeException("Category not found");
                }
         Category category = categoryMapper.mappedFrom(categoryDTO);
         category.setCategoryID(categoryId);
        return categoryRepository.save(category);
    }

    public Category categoryName(String categoryName){
        Category category = categoryRepository.findByCategoryName(categoryName);
        if (category == null){
            throw new RuntimeException("nOT FOUND");
        }
        return category;
    }
}

