package com.coding.productcategories.services;

import com.coding.productcategories.models.Category;
import com.coding.productcategories.models.Product;
import com.coding.productcategories.repositories.CategoryRepository;
import com.coding.productcategories.repositories.ProductRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepo;

    @Autowired
    ProductRepository productRepo;

    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    public Category addCategory(Category category) {
        category.setName(WordUtils.capitalizeFully(category.getName()));
        return categoryRepo.save(category);
    }

    public Category findCategoryById(Long id) {
        return categoryRepo.findCategoryById(id);
    }

    public List<Product> findAllAddedProducts(Category category) {
        return productRepo.findAllByCategories(category);
    }

    public List<Product> findAllMissingProducts(Category category) {
        return productRepo.findByCategoriesNotContains(category);
    }

    public Category addProductToCategory(Long categoryId, Long productId) {
        Category oneCategory = categoryRepo.findCategoryById(categoryId);
        Product oneProduct = productRepo.findProductById(productId);
        oneCategory.getProducts().add(oneProduct);
        return categoryRepo.save(oneCategory);

    }
}
