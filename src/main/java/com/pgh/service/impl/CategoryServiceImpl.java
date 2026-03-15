/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pgh.service.impl;

import com.pgh.pojo.Category;
import com.pgh.repository.CategoryRepository;
import com.pgh.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author admin
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    
    @Autowired
    private CategoryRepository cateRepo; 
    
    @Override
    public List<Category> getCates() {
        return this.cateRepo.getCates();
    }
    
}
