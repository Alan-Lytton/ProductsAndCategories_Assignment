package com.coding.productcategories.repositories;


import com.coding.productcategories.models.Category;
import com.coding.productcategories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {

    List<Category> findAll();

    List<Category> findAllByProducts(Product product);

    List<Category> findByProductsNotContains(Product product);

    Category findCategoryById(Long categoryId);
}
