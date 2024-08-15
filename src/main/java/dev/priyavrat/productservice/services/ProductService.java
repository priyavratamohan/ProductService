package dev.priyavrat.productservice.services;

import dev.priyavrat.productservice.dtos.GenericProductDTO;
import dev.priyavrat.productservice.models.Product;

import java.util.List;

public interface ProductService {
    GenericProductDTO getProductByID(Long id);

    GenericProductDTO createProduct(GenericProductDTO product);

    List<GenericProductDTO> getProducts();
}
