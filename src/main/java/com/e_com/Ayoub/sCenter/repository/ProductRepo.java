package com.e_com.Ayoub.sCenter.repository;

import com.e_com.Ayoub.sCenter.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
    Page<Product> findAll(Specification<Product> spec , Pageable pageable);
    Specification<Product> searchByNameContaining(String keyword);
    Specification<Product> findByBookId(Integer bookId);
    Specification<Product> findByCategoryId(Integer categoryId);
    Specification<Product> findByBookIdAndCategoryId(Integer bookId , Integer categoryId);


}
