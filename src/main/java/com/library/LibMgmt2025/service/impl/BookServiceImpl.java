package com.library.LibMgmt2025.service.impl;

import com.library.LibMgmt2025.dto.BookDto;
import com.library.LibMgmt2025.service.BookService;
import com.library.LibMgmt2025.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public void addBook(BookDto bookDto) {
        //Business process
        bookDto.setBookId(UtilData.generateBookId());
        bookDto.setLastUpdateDate(String.valueOf(UtilData.generateTodayDate()));
        bookDto.setLastUpdateTime(String.valueOf(UtilData.generatecurrentTime()));

        System.out.println(bookDto);
    }

    @Override
    public void deleteBook(String bookId) {

    }

    @Override
    public void updateBook(String bookId, BookDto bookDto) {

    }

    @Override
    public BookDto getSelectedBook(String bookId) {
        return  (new BookDto("B005",
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

    @Override
    public List<BookDto> getAllBooks() {
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

        return bookList;

    }
}
