package com.e_com.Ayoub.sCenter.controller;

import com.e_com.Ayoub.sCenter.model.BookResponse;
import com.e_com.Ayoub.sCenter.model.CategoryResponse;
import com.e_com.Ayoub.sCenter.model.ProductResponse;
import com.e_com.Ayoub.sCenter.service.BookService;
import com.e_com.Ayoub.sCenter.service.CategoryService;
import com.e_com.Ayoub.sCenter.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService ;
    private final CategoryService categoryService ;
    private final BookService bookService ;

    public ProductController(ProductService productService, CategoryService categoryService, BookService bookService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") int productId){
        ProductResponse productResponse  = productService.getProductById(productId);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> getProducts(){
        List<ProductResponse> productResponses = productService.getProducts();
        return new ResponseEntity<>(productResponses, HttpStatus.OK);

    }

    @GetMapping("/books")
    public ResponseEntity<List<BookResponse>> getBooks(){
        List<BookResponse> bookResponses = bookService.getAllBooks();
        return new ResponseEntity<>(bookResponses, HttpStatus.OK);

    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryResponse>> getCategories(){
        List<CategoryResponse> categoryResponses  =categoryService.getAllCategory();
        return new ResponseEntity<>(categoryResponses , HttpStatus.OK);
    }
}
