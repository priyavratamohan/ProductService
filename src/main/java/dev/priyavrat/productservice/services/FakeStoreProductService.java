package dev.priyavrat.productservice.services;

import dev.priyavrat.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    @Override
    public String getProductByID(Long id) {
        return "Here is the new Product ID: " + id;
    }
}
