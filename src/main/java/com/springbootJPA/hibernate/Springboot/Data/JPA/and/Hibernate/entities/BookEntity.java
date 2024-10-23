package com.springbootJPA.hibernate.Springboot.Data.JPA.and.Hibernate.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "book",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"isbn"})
        },
        indexes = {
                @Index(columnList = "isbn")
        }
)
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 50)
    private String tittle;
    @Column(nullable = false, length = 20)
    private String isbn;
    @Column(nullable = false)
    private Integer price;
    @ManyToOne
    @JoinColumn(name = "books_author" , referencedColumnName = "id")
    @JsonIgnore
    private AuthorEntity author;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getTittle(), that.getTittle()) && Objects.equals(getIsbn(), that.getIsbn()) && Objects.equals(getCreatedAt(), that.getCreatedAt()) && Objects.equals(getUpdatedAt(), that.getUpdatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTittle(), getIsbn(), getCreatedAt(), getUpdatedAt());
    }
}
