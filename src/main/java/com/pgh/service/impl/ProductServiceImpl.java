/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pgh.service.impl;

import com.pgh.pojo.Product;
import com.pgh.repository.ProductRepository;
import com.pgh.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
        return productRepo.getProducts(params);
    }
    
    
}
