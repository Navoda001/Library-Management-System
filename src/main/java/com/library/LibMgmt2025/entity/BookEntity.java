package com.library.LibMgmt2025.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "book")
public class BookEntity {
    @Id
    private String bookId;
    private String bookName;
    private String author;
    private String edition;
    private String publisher;
    private String isbn;
    private Double price;
    private Integer totalQty;
    private Integer availableQty;
    private LocalDate lastUpdateDate;
    private Time lastUpdateTime;
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<LendingEntity> lendings;
}
