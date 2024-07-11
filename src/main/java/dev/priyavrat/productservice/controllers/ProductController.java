package dev.priyavrat.productservice.controllers;

import dev.priyavrat.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public void getAllProducts(){

    }

    @GetMapping("{id}")
    public String getProductByID(@PathVariable("id") Long id){
        return productService.getProductByID(id);
    }
    @DeleteMapping("{id}")
    public void deleteProductByID(){

    }

    @PostMapping()
    public String createProduct(){
        return "Created new product with ID: " + UUID.randomUUID();
    }

    @PutMapping("{id}")
    public void updateProductByID(){

    }
}
