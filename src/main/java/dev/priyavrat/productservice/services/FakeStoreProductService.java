package dev.priyavrat.productservice.services;

import dev.priyavrat.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service
public class FakeStoreProductService implements ProductService{

    @Override
    public Product getProductByID(Long id) {
        return new Product();
    }
}
