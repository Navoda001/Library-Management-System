package com.library.LibMgmt2025.service;

import com.library.LibMgmt2025.dto.BookDto;

import java.awt.print.Book;
import java.util.List;

public interface BookService {
 void addBook(BookDto bookDto);
 void deleteBook(String bookId);
 void updateBook(String bookId,BookDto bookDto);
 BookDto getSelectedBook(String bookId);
 List<BookDto> getAllBooks();

}
