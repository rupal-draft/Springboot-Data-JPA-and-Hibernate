package com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.services;

import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.entities.AuthorEntity;
import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorEntity getAuthorbyId(String authorName) {
        return authorRepository.findByName(authorName);
    }

    public List<AuthorEntity> getAllAuthors() {
        return authorRepository.findAll();
    }

    public AuthorEntity createAuthor(AuthorEntity inputAuthor) {
        return authorRepository.save(inputAuthor);
    }

    public AuthorEntity updateAuthor(AuthorEntity inputAuthor, Long authorId) {
        inputAuthor.setId(authorId);
        return authorRepository.save(inputAuthor);
    }
}
