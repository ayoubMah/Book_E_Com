package com.e_com.Ayoub.sCenter.service;

import com.e_com.Ayoub.sCenter.model.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductResponse getProductById(Integer productId);
    Page<ProductResponse> getProducts(Pageable pageable , Integer bookId , Integer categoryId , String keyword);
}
