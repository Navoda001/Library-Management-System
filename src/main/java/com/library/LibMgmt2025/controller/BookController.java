package com.library.LibMgmt2025.controller;


import com.library.LibMgmt2025.dto.BookDto;
import com.library.LibMgmt2025.exception.BookNotFoundException;
import com.library.LibMgmt2025.service.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;
//    @Autowired
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> addBook(@RequestBody BookDto bookDto){
      logger.info("call the addBook() with param {}", bookDto);
      if (bookDto == null){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    bookService.addBook(bookDto);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
@DeleteMapping
  public ResponseEntity<Void> deleteBook(@RequestParam("bookIdKey") String bookIdValue){
      if (bookIdValue == null){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
      try {
           bookService.deleteBook(bookIdValue);
           return ResponseEntity.noContent().build();
       } catch (BookNotFoundException e) {
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }catch (Exception e){
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
       }

  }

  @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> updateBook(@RequestParam ("bookId") String bookId , @RequestBody BookDto bookDto){
      if (bookDto == null || bookId == null){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
     try{
         bookService.updateBook(bookId, bookDto);
         return ResponseEntity.noContent().build();
     } catch (BookNotFoundException e) {
         e.printStackTrace();
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }catch (Exception e){
         e.printStackTrace();
         return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
     }
  }

  @GetMapping
  public ResponseEntity<BookDto> getSelectedBook(@RequestParam("bookId") String bookId){
      if (bookId == null){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
      try{
          var selectedBook = bookService.getSelectedBook(bookId);
          return ResponseEntity.ok(selectedBook);
      } catch (BookNotFoundException e) {
          e.printStackTrace();
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }catch (Exception e){
          e.printStackTrace();
          return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }

    }
@GetMapping("getAllbooks")
    public ResponseEntity<List<BookDto>> getAllBooks(){
    return ResponseEntity.ok(bookService.getAllBooks());
}
}
