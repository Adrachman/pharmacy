package com.home.pharmacy.controllers;

import com.home.pharmacy.Product;
import com.home.pharmacy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @RequestMapping("/products")
    public String viewProducts(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }
}
