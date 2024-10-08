package dev.priyavrat.productservice.controllers;

import dev.priyavrat.productservice.dtos.GenericProductDTO;
import dev.priyavrat.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductDTO> getAllProducts(){
        return productService.getProducts();
    }

    @GetMapping("{id}")
    public GenericProductDTO getProductByID(@PathVariable("id") Long id){
        return productService.getProductByID(id);
    }
    @DeleteMapping("{id}")
    public void deleteProductByID(){

    }

    @PostMapping()
    public GenericProductDTO createProduct(@RequestBody GenericProductDTO product){
        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public void updateProductByID(){

    }
}
