package com.product.service;

import org.springframework.stereotype.Service;

import com.product.dto.ProductRequest;
import com.product.entity.Product;
import com.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public Product createProduct(ProductRequest request){
        Product product=Product.builder().
        name(request.name())
        .description(request.description())
        .price(request.price())
        build();
        productRepository.save(product);
        return product;
    }

}
