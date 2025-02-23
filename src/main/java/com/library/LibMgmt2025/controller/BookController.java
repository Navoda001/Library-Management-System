package com.library.LibMgmt2025.controller;


import com.library.LibMgmt2025.dto.BookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @GetMapping("health")
  public  String healthTest(){
        return "Book Controller Running";
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> addBook(@RequestBody BookDto bookDto){
    System.out.println(bookDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
@DeleteMapping
  public ResponseEntity<Void> deleteBook(@RequestParam("bookIdKey") String bookIdValue){
       System.out.println(bookIdValue);
        return ResponseEntity.noContent().build();
  }

  @PatchMapping(value = "/{bookId}", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> updateBook(@PathVariable String bookId , @RequestBody BookDto bookDto){
    System.out.println(bookDto);
    System.out.println(bookId);
        return ResponseEntity.noContent().build();
  }

  @GetMapping("{bookId}")
  public ResponseEntity<BookDto> getSelectedBook(@PathVariable String bookId){
        System.out.println("Get selected book for :"+bookId);
    return ResponseEntity.ok(new BookDto("B005",
            "Spring boot -2025",
            "Kamal perera",
            "2024",
            "Oxford Publisher",
            "14466-56136",
            500.0,
            50,
            10,
            "2025-01-11",
            "16.25"));
    }
@GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
    List<BookDto> bookList = new ArrayList<>();
    bookList.add(new BookDto("B005",
            "Spring boot -2025",
            "Kamal Perera",
            "2024",
            "Oxford Publisher",
            "14466-56136",
            500.0,
            50,
            10,
            "2025-01-11",
            "16.25"));
    bookList.add(new BookDto("B88",
            "Data structures and Algorithms",
            "Sunil Fernando",
            "2022",
            "Oxford Publisher",
            "1756-56136",
            750.0,
            40,
            15,
            "2025-02-11",
            "12.25"));

    bookList.add(new BookDto("B6563",
            "Microservice Architecture",
            "Aruna Perera",
            "2025",
            "Packt",
            "9-45628-486214",
            1000.0,
            30,
            5,
            "2024-12-02",
            "08.58"));

    bookList.add(new BookDto("B6563",
            "Cloud Computing Essentials",
            "Kavinda Jayasuriya",
            "2020",
            "Wiley",
            "9-002-445218-50248",
            1200.0,
            20,
            10,
            "2025-02-04",
            "16.44"));

    return ResponseEntity.ok(bookList);
}
}
