package dev.priyavrat.productservice.services;

import dev.priyavrat.productservice.models.Product;

public interface ProductService {
    Product getProductByID(Long id);
}
