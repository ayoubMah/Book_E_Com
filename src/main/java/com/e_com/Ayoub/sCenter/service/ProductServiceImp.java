package com.e_com.Ayoub.sCenter.service;

import com.e_com.Ayoub.sCenter.entity.Product;
import com.e_com.Ayoub.sCenter.model.ProductResponse;
import com.e_com.Ayoub.sCenter.repository.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class ProductServiceImp implements ProductService{


    private final ProductRepo productRepo;

    public ProductServiceImp( ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public ProductResponse getProductById(int productId) {
        log.info("Fetching product by id : {}  ", productId);
        Product product = productRepo.findById(productId)
                .orElseThrow(()-> new RuntimeException("product with this id doesn't exist :(  " ));
        //TODO : convert the product to product response
        ProductResponse productResponse = convertToProductResponse(product);
        log.info("Fetch Product by Id : {}", productId);

        return productResponse;

    }



    @Override
    public List<ProductResponse> getProducts() {
        log.info("Fetching Products");
        // fetching from DB
        List<Product> productList = productRepo.findAll();
        //map
        List<ProductResponse> productResponses = productList.stream()
                .map(this:: convertToProductResponse)
                .collect(Collectors.toList());
        log.info("fetch all products !");
        return productResponses;
    }

//private methode
    private ProductResponse convertToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .pictureUrl(product.getPictureUrl())
                .book(product.getBook().getName())
                .category(product.getCategory().getName())
                .build();

    }
}
