package com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.controllers;

import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.entities.AuthorEntity;
import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.entities.BookEntity;
import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.services.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/{bookId}")
    public BookEntity getBookbyId(@PathVariable Long bookId){
        return bookService.getBookbyId(bookId);
    }

    @GetMapping
    public List<BookEntity> getAllBooks(@RequestParam(defaultValue = "id") String sortBy,@RequestParam(defaultValue = "1") Integer pageNumber){
        return bookService.getAllBooks(sortBy,pageNumber);
    }

    @PostMapping
    public BookEntity createBook(@RequestBody BookEntity inputBook){
        return bookService.createBook(inputBook);
    }

    @PutMapping(path = "/{authorId}/{bookId}")
    public AuthorEntity assignBookToAuthor(@PathVariable Long authorId ,@PathVariable Long bookId){
        return bookService.assignBookToAuthor(authorId,bookId);
    }
}
