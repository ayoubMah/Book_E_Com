package com.e_com.Ayoub.sCenter.repository;

import com.e_com.Ayoub.sCenter.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
