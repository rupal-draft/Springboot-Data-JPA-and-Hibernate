package com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.controllers;


import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.entities.AuthorEntity;
import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.services.AuthorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(path = "/{authorName}")
    public AuthorEntity getAuthorbyId(@PathVariable String authorName){
        return authorService.getAuthorbyId(authorName);
    }

    @GetMapping
    public List<AuthorEntity> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @PostMapping
    public AuthorEntity createAuthor(@RequestBody AuthorEntity inputAuthor){
        return authorService.createAuthor(inputAuthor);
    }

    @PutMapping(path = "/{authorId}")
    public AuthorEntity updateAuthor(@RequestBody AuthorEntity inputAuthor,@PathVariable Long authorId){
        return authorService.updateAuthor(inputAuthor,authorId);
    }
}
