package com.coding.productcategories.services;


import com.coding.productcategories.models.Category;
import com.coding.productcategories.models.Product;
import com.coding.productcategories.repositories.CategoryRepository;
import com.coding.productcategories.repositories.ProductRepository;
import org.apache.commons.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    CategoryRepository categoryRepo;

    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(Product product) {
        product.setName(WordUtils.capitalizeFully(product.getName()));
        return productRepo.save(product);
    }

    public List<Category> findAllAddedCategories(Product product) {
        return categoryRepo.findAllByProducts(product);
    }

    public List<Category> findAllMissingCategories(Product product) {
        return categoryRepo.findByProductsNotContains(product);
    }

    public Product findProductById(Long id) {
        Optional<Product> oneProduct = productRepo.findById(id);
        if(oneProduct.isPresent()){
            return oneProduct.get();
        }
        return null;
    }

    public Product addCategoryToProduct(Long productId, Long categoryId) {
        Product oneProduct = productRepo.findProductById(productId);
        Category oneCategory = categoryRepo.findCategoryById(categoryId);
        oneProduct.getCategories().add(oneCategory);
        return productRepo.save(oneProduct);
    }
}
