package com.product.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.product.dto.ProductRequest;
import com.product.dto.ProductResponse;
import com.product.entity.Product;
import com.product.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public ProductResponse createProduct(ProductRequest request){
        Product product = Product.builder()
            .name(request.name())
            .description(request.description())
            .price(request.price())
            .build();
       Product savedProduct= productRepository.save(product);
        return new ProductResponse(savedProduct.getId(), 
        savedProduct.getName(), savedProduct.getDescription(), savedProduct.getPrice());
    }
    public List<ProductResponse> getAll(){
        return productRepository.findAll()
        .stream()
        .map(product->new ProductResponse(product.getId(),
         product.getName(), product.getDescription(), product.getPrice())).toList();
    }

}
