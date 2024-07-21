package com.e_com.Ayoub.sCenter.service;

import com.e_com.Ayoub.sCenter.model.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse getProductById(int productId);
    List<ProductResponse> getProducts();
}
