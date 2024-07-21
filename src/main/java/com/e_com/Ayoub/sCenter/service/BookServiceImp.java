package com.e_com.Ayoub.sCenter.service;

import com.e_com.Ayoub.sCenter.model.BookResponse;
import com.e_com.Ayoub.sCenter.repository.BookRepo;
import com.e_com.Ayoub.sCenter.entity.Book;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
public class BookServiceImp implements BookService{

    private final BookRepo bookRepo;

    public BookServiceImp(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public List<BookResponse> getAllBooks() {
        log.info("Fetching All Books! ");
        //fetch books
        List<Book> bookList = bookRepo.findAll();

        //now use stream operator to map with response
        List<BookResponse> bookResponses  = bookList.stream()
                .map(this :: convertToBookResponse)
                .collect(Collectors.toList()) ;
        log.info("Fetch All Books ");
        return bookResponses;
    }

    private BookResponse convertToBookResponse(Book book) {
        return BookResponse.builder()
                .Id(book.getId())
                .name(book.getName())
                .author(book.getAuthor())
                .build();
    }
}
