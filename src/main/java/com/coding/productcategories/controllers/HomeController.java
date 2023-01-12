package com.coding.productcategories.controllers;


import com.coding.productcategories.services.CategoryService;
import com.coding.productcategories.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ProductService productServ;

    @Autowired
    CategoryService categoryServ;

    @GetMapping("")
    public String dashboard(Model model){
        model.addAttribute("products", productServ.findAllProducts());
        model.addAttribute("categories", categoryServ.findAllCategories());
        return "dashboard.jsp";
    }
}
