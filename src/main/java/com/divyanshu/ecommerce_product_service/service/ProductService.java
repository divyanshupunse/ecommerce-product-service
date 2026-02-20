package com.divyanshu.ecommerce_product_service.service;

import com.divyanshu.ecommerce_product_service.entity.Product;
import com.divyanshu.ecommerce_product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product addProduct(Product product){
        return repository.save(product);
    }
    public List<Product> getProducts(){
        return repository.findAll();
    }
    public Product getProductById(int id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public Product updateProduct(int id , Product product){

        Product check=repository.findById(id).orElseThrow(() -> new  RuntimeException("Product not found"));
        check.setName(product.getName());
        check.setDescription(product.getDescription());
        check.setCategory(product.getCategory());
        check.setPrice(product.getPrice());
        check.setStock(product.getStock());

        return repository.save(check);
    }
    public void deleteProduct(int id){
        repository.deleteById(id);
    }



}
