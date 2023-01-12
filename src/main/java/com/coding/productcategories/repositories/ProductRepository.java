package com.coding.productcategories.repositories;


import com.coding.productcategories.models.Category;
import com.coding.productcategories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findAll();

    List<Product> findAllByCategories(Category category);

    List<Product> findByCategoriesNotContains(Category category);

    Product findProductById(Long productId);
}
