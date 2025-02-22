package com.library.LibMgmt2025.controller;


import com.library.LibMgmt2025.dto.BookDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("books")
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
}
