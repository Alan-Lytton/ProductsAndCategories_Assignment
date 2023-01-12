package com.coding.productcategories.controllers;


import com.coding.productcategories.models.Category;
import com.coding.productcategories.models.Product;
import com.coding.productcategories.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryServ;

    @GetMapping("/new")
    public String newCategory(@ModelAttribute("newCategory")Category category){
        return "newCategory.jsp";
    }

    @PostMapping("/new")
    public String processCategory(@Valid @ModelAttribute("newCategory")Category category, BindingResult result){
        if(result.hasErrors()){
            return "newCategory.jsp";
        }
        categoryServ.addCategory(category);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String addProductToCategory(@PathVariable("id")Long id, @ModelAttribute("addProduct")Product product, Model model){
        Category oneCategory = categoryServ.findCategoryById(id);
        model.addAttribute("category",oneCategory);
        model.addAttribute("addedProducts", categoryServ.findAllAddedProducts(oneCategory));
        model.addAttribute("availableProducts", categoryServ.findAllMissingProducts(oneCategory));
        return "addProduct.jsp";
    }

    @PostMapping("/{categoryId}")
    public String processAddProductToCategory(@PathVariable("categoryId")Long id,@ModelAttribute("addProduct")Product product,BindingResult result){
        if (result.hasErrors()){
            return "addProduct.jsp";
        }
        categoryServ.addProductToCategory(id,product.getId());
        return "redirect:/";
    }
}
