package dev.priyavrat.productservice.services;

import dev.priyavrat.productservice.dtos.FakeStoreProductDTO;
import dev.priyavrat.productservice.dtos.GenericProductDTO;
import dev.priyavrat.productservice.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private final RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestURL = "https://fakestoreapi.com/products/{id}";

    private String createProductRequestURL = "https://fakestoreapi.com/products/";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    public GenericProductDTO createProduct(GenericProductDTO product){
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> response = restTemplate.postForEntity(
              createProductRequestURL, product, GenericProductDTO.class
        );

        return response.getBody();
    }

    @Override
    public GenericProductDTO getProductByID(Long id) {
        RestTemplate restTemplate=restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity(getProductRequestURL, FakeStoreProductDTO.class, id);

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();
        if (fakeStoreProductDTO == null) {
            throw new RuntimeException("Failed to retrieve product details from FakeStore API.");
        }
        GenericProductDTO product = new GenericProductDTO();
        product.setImage(fakeStoreProductDTO.getImage());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setCategory(fakeStoreProductDTO.getCategory());

        return product;
    }
}
