package com.product.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductRequest;
import com.product.entity.Product;
import com.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
private final ProductService productService;
@PostMapping("")
public Product create(@RequestBody ProductRequest productRequest){
    return productService.createProduct(productRequest);
}
}
