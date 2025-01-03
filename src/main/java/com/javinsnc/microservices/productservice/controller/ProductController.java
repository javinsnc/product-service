package com.javinsnc.microservices.productservice.controller;

import com.javinsnc.microservices.productservice.dto.ProductRequest;
import com.javinsnc.microservices.productservice.dto.ProductResponse;
import com.javinsnc.microservices.productservice.model.Product;
import com.javinsnc.microservices.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        return productService.getAllProducts();
    }
}
