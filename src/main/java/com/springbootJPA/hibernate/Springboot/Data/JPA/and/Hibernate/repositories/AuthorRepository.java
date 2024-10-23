package com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.repositories;

import com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
    AuthorEntity findByName(String authorName);
}
