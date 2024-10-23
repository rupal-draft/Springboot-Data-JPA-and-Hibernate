package com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.services;

import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.entities.AuthorEntity;
import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.entities.BookEntity;
import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.repositories.AuthorRepository;
import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.repositories.BookRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService
{
    private final int PAGE_SIZE=3;
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public BookEntity getBookbyId(Long bookId) {
        return bookRepository.findById(bookId).orElse(null);
    }

    public List<BookEntity> getAllBooks(String sortBy, Integer pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber,PAGE_SIZE, Sort.by(sortBy).ascending());
        return bookRepository.findAll(pageable).getContent();
    }

    public BookEntity createBook(BookEntity inputBook) {
        return bookRepository.save(inputBook);
    }

    public AuthorEntity assignBookToAuthor(Long authorId, Long bookId) {
        Optional<AuthorEntity> authorEntity = authorRepository.findById(authorId);
        Optional<BookEntity> bookEntity = bookRepository.findById(bookId);

        return authorEntity.flatMap(authorEntity1 ->
            bookEntity.map(bookEntity1 -> {
                bookEntity1.setAuthor(authorEntity1);
                bookRepository.save(bookEntity1);
                authorEntity1.getBooks().add(bookEntity1);
                return authorEntity1;
            }) ).orElse(null);

    }
}
