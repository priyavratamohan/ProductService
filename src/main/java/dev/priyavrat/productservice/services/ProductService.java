package dev.priyavrat.productservice.services;

import dev.priyavrat.productservice.dtos.GenericProductDTO;
import dev.priyavrat.productservice.models.Product;

public interface ProductService {
    GenericProductDTO getProductByID(Long id);

    GenericProductDTO createProduct(GenericProductDTO product);
}
