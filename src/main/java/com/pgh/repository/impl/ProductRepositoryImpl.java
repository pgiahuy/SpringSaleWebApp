/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pgh.repository.impl;

import com.pgh.pojo.Product;
import com.pgh.repository.ProductRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
@PropertySource("classpath:configs.properties")
public class ProductRepositoryImpl implements ProductRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private Environment env;
    
    public List<Product> getProducts(Map<String, String> params) {
        
        Session session = factory.getObject().getCurrentSession();   
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Product> q = b.createQuery(Product.class);
        Root root = q.from(Product.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
            }

            String fromPrice = params.get("fromPrice");
            if (fromPrice != null && !fromPrice.isEmpty()) {
                predicates.add(b.greaterThanOrEqualTo(root.get("price"), fromPrice));
            }

            String toPrice = params.get("toPrice");
            if (toPrice != null && !toPrice.isEmpty()) {
                predicates.add(b.lessThanOrEqualTo(root.get("price"), toPrice));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }

        Query query = session.createQuery(q);

        // xu ly phan trang
        if (params != null) {
            int pageSize = env.getProperty("products.page_size", Integer.class );
            
            int page = Integer.parseInt(params.getOrDefault("page", "1"));
            int start = (page - 1) * pageSize;

            query.setMaxResults(pageSize);
            query.setFirstResult(start);
        }

        return query.getResultList();
    }

//    public Product getProductById(int id) {
//        try (Session session = HibernateUtils.getFACTORY().openSession()) {
//            return session.get(Product.class, id);
//        }
//    }
//    
//    public void addOrUpdateProduct(Product p) {
//        try (Session session = HibernateUtils.getFACTORY().openSession()) {
//            if (p.getId() != null) {
//                session.merge(p);
//            } else {
//                session.persist(p);
//            }
//        }
//    }
//    
//    public void deleteProduct(int id) {
//        try (Session session = HibernateUtils.getFACTORY().openSession()) { 
//            Product p = this.getProductById(id);
//            session.remove(p);
//        }
//    }
}
