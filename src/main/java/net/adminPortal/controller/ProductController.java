package net.adminPortal.controller;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import net.adminPortal.entity.Product;
import net.adminPortal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.adminPortal.exception.ResourceNotFoundException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    // get all aliases
    @GetMapping("/products")
    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    // create alias rest api
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    // get alias by id rest api
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProductsByProductId(@PathVariable(value="productId") Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with productID :" + productId));
        return ResponseEntity.ok(product);
    }

    // update alias rest api

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product productDetails){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product does not exist with productID :" + productId));

        product.setProductId(productDetails.getProductId());

        Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // delete employee rest api
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<Map<String, Boolean>> deleteProduct(@PathVariable Long productId){
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Report does not exist with productID :" + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
