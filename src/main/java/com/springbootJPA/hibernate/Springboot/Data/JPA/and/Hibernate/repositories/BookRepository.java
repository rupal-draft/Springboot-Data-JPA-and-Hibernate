package com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.repositories;

import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
