package com.devops.demo_devops.Controllers;

import com.devops.demo_devops.Reposotories.ProductsRepository;
import com.devops.demo_devops.Tables.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    ProductsRepository productsRepository;

    // Get all product
    @GetMapping("/product")
    public List<Products> findAll() {
        return productsRepository.findAll();
    }

    // Get product by productCode
    @GetMapping("/product/{productCode}")
    public Optional<Products> findById(@PathVariable String productCode){
        int productId = Integer.parseInt(productCode);
        return productsRepository.findById(productId);
    }

    // Add new product.
    @PostMapping("/product/create")
    public String create(@RequestBody Map<String, String> body) {

        int productCode = Integer.parseInt(body.get("productCode"));
        String productName = body.get("productName");
        String productDescription = body.get("productDescription");
        Double buyPrice = Double.parseDouble(body.get("buyPrice"));

        Optional<Products> searchForProductId = productsRepository.findById(productCode);

        Thread.sleep(2000);

        if (searchForProductId.isPresent()) {

            return "ProductCode already existed";

        } else {
            productsRepository.save(new Products(productCode, productName, productDescription, buyPrice));

            return "Add new product successed";
        }
    }

    // Delete product by productCode
    @DeleteMapping("/product/delete/{productCode}")
    public List<Products> deleteProduct(@PathVariable int productCode) throws InterruptedException {
        productsRepository.deleteById(productCode);
        Thread.sleep(1000);
        return productsRepository.findAll();
    }
}
