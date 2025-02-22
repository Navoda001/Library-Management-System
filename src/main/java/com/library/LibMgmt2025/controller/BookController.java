package com.library.LibMgmt2025.controller;

import com.library.LibMgmt2025.dto.BookDto;
import org.springframework.http.MediaType;
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
  public BookDto addBook(@RequestBody BookDto bookDto){
    System.out.println(bookDto);
    return bookDto;
  }
}
