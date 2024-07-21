package com.e_com.Ayoub.sCenter.service;

import com.e_com.Ayoub.sCenter.entity.Category;
import com.e_com.Ayoub.sCenter.model.CategoryResponse;
import com.e_com.Ayoub.sCenter.repository.CategoryRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImp implements CategoryService{

    private static final Logger log = LoggerFactory.getLogger(CategoryServiceImp.class);
    private final CategoryRepo categoryRepo ;

    public CategoryServiceImp(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }


    @Override
    public List<CategoryResponse> getAllCategory() {
        log.info("Fetching All Categories :)" );
        //TODO: ferch types from DB
        List<Category> categoryList = categoryRepo.findAll();
        //TODO: use stream operator to map with response
        List<CategoryResponse> categoryResponses = categoryList.stream()
                .map(this :: converToCategoryRespose)
                .collect(Collectors.toList());
        return categoryResponses;

    }

    private CategoryResponse converToCategoryRespose(Category category) {
        return CategoryResponse.builder()
                .Id(category.getId())
                .name(category.getName())
                .build();
    }
}
