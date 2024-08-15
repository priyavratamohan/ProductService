package dev.priyavrat.productservice.services;

import dev.priyavrat.productservice.dtos.FakeStoreProductDTO;
import dev.priyavrat.productservice.dtos.GenericProductDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private final RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestURL = "https://fakestoreapi.com/products/{id}";

    private String productRequestBaseURL = "https://fakestoreapi.com/products/";

    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder=restTemplateBuilder;
    }

    public GenericProductDTO createProduct(GenericProductDTO product){
        RestTemplate restTemplate= restTemplateBuilder.build();
        ResponseEntity<GenericProductDTO> response = restTemplate.postForEntity(
                productRequestBaseURL, product, GenericProductDTO.class
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

    @Override
    public List<GenericProductDTO> getProducts() {
        RestTemplate restTemplate= restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDTO[]> response =  restTemplate.getForEntity(productRequestBaseURL,FakeStoreProductDTO[].class);

        List<GenericProductDTO> answer = new ArrayList<>();

        for (FakeStoreProductDTO fakeStoreProductDTO: response.getBody()){
            GenericProductDTO product = new GenericProductDTO();
            product.setImage(fakeStoreProductDTO.getImage());
            product.setDescription(fakeStoreProductDTO.getDescription());
            product.setTitle(fakeStoreProductDTO.getTitle());
            product.setCategory(fakeStoreProductDTO.getCategory());

            answer.add(product);
        }

        return answer;
    }
}
