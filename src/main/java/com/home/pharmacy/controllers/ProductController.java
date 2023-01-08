package com.home.pharmacy.controllers;

import com.home.pharmacy.Product;
import com.home.pharmacy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/products")
    public String viewProducts(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }

    @PostMapping(path = "/products")
    public String addProduct(Product p, Model model){
        productService.addProduct(p);
        List<Product> products =productService.findAll();
        model.addAttribute("products",products);
        return "products";
    }
}
