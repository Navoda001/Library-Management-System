package com.library.LibMgmt2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookDto implements Serializable {
     private String bookId;
     private String bookName;
     private String author;
     private String edition;
     private String publisher;
     private String isbn;
     private Double price;
     private Integer totalQty;
     private Integer availableQty;
     private String lastUpdateDate;
     private String lastUpdateTime;

}
