package com.coding.productcategories.controllers;


import com.coding.productcategories.models.Category;
import com.coding.productcategories.models.Product;
import com.coding.productcategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

     @Autowired
    ProductService productServ;

     @GetMapping("/new")
    public String newProduct(@ModelAttribute("newProduct") Product product){
         return "newProduct.jsp";
     }

     @PostMapping("/new")
    public String processProduct(@Valid @ModelAttribute("newProduct")Product product, BindingResult result){
         if(result.hasErrors()){
             return "newProduct.jsp";
         }
         productServ.addProduct(product);
         return "redirect:/";
     }

     @GetMapping("/{id}")
    public String addCategoryToProduct(@PathVariable("id")Long id, @ModelAttribute("addCategory") Category category, Model model){
         Product singleProduct = productServ.findProductById(id);
         model.addAttribute("product", singleProduct );
         model.addAttribute("addedCategories", productServ.findAllAddedCategories(singleProduct));
         model.addAttribute("availableCategories", productServ.findAllMissingCategories(singleProduct));
         return "addCategory.jsp";
     }

     @PostMapping("/{productId}")
    public String processAddCategoryToProduct(@PathVariable("productId")Long id, @ModelAttribute("addCategory")Category category, BindingResult result){
         if (result.hasErrors()){
             return "addCategory.jsp";
         }
         productServ.addCategoryToProduct(id,category.getId());
         return "redirect:/";
     }

}
