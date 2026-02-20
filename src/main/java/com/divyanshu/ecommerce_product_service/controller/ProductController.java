package com.divyanshu.ecommerce_product_service.controller;

import com.divyanshu.ecommerce_product_service.entity.Product;
import com.divyanshu.ecommerce_product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/add")
    public String addProduct(@RequestBody Product product){
        service.addProduct(product);
        return "Product added successfully";
    }

    @GetMapping("/get")
    public List<Product> getProducts(){
        return service.getProducts();
    }
    @GetMapping("/get/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }
    @PutMapping("/update/{id}")
    public String updateProduct(@PathVariable int id , @RequestBody Product product){
        service.updateProduct(id,product);
        return "Product updated successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        service.deleteProduct(id);
        return "Product deleted successfully";
    }


}
