package com.e_com.Ayoub.sCenter.service;

import com.e_com.Ayoub.sCenter.entity.Product;
import com.e_com.Ayoub.sCenter.model.ProductResponse;
import com.e_com.Ayoub.sCenter.repository.ProductRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
    public ProductResponse getProductById(Integer productId) {
        log.info("Fetching product by id : {}  ", productId);
        Product product = productRepo.findById(productId)
                .orElseThrow(()-> new RuntimeException("product with this id doesn't exist :(  " ));
        //TODO : convert the product to product response
        ProductResponse productResponse = convertToProductResponse(product);
        log.info("Fetch Product by Id : {}", productId);

        return productResponse;

    }



    @Override
    public Page<ProductResponse> getProducts(Pageable pageable , Integer bookId , Integer categoryId , String keyword) {
        log.info("Fetching Products");
        Specification<Product> spec  = Specification.where(null) ;
        if (bookId != null ){
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("book").get("id"), bookId));
        }
        if(categoryId != null){
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("category").get("id"), categoryId));
        }
        if(keyword != null && keyword.isEmpty()){
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + keyword + "%"));
        }
        log.info("fetch all products !");
        return productRepo.findAll(spec , pageable).map(this :: convertToProductResponse) ;
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
