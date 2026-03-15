/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pgh.repository;

import com.pgh.pojo.Product;
import java.util.List;
import java.util.Map;

/**
 *
 * @author admin
 */
public interface ProductRepository {
    public List<Product> getProducts(Map<String, String> params);
    
}
