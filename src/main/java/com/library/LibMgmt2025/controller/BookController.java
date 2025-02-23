package com.library.LibMgmt2025.controller;


import com.library.LibMgmt2025.dto.BookDto;
import com.library.LibMgmt2025.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    @GetMapping("health")
  public  String healthTest(){
        return "Book Controller Running";
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> addBook(@RequestBody BookDto bookDto){
//    System.out.println(bookDto);
    bookService.addBook(bookDto);
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
        return ResponseEntity.ok(bookService.getSelectedBook(bookId));

    }
@GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
    return ResponseEntity.ok(bookService.getAllBooks());
}
}
