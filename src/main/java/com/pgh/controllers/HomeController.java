/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pgh.controllers;

import com.pgh.service.CategoryService;
import com.pgh.service.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;

/**
 *
 * @author admin
 */

@Controller
public class HomeController {
    @Autowired
    private CategoryService cateService;
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String,String> params){
        model.addAttribute("categories", this.cateService.getCates());
        
        model.addAttribute("products", this.productService.getProducts(params));
        return "index";
    }
    
}
