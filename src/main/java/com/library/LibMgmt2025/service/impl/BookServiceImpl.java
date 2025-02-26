package com.library.LibMgmt2025.service.impl;

import com.library.LibMgmt2025.dao.BookDao;
import com.library.LibMgmt2025.dto.BookDto;
import com.library.LibMgmt2025.entity.BookEntity;
import com.library.LibMgmt2025.exception.BookNotFoundException;
import com.library.LibMgmt2025.service.BookService;
import com.library.LibMgmt2025.util.EntityDtoConvert;
import com.library.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;
    private final EntityDtoConvert entityDtoConvert;

    @Override
    public void addBook(BookDto bookDto) {
        //Business process
        bookDto.setBookId(UtilData.generateBookId());
        bookDto.setLastUpdateDate(UtilData.generateTodayDate());
        bookDto.setLastUpdateTime(UtilData.generatecurrentTime());

        //Pass to Dao
        BookEntity bookEntity = entityDtoConvert.convertBookDtoToBookEntity(bookDto);
        System.out.println(bookEntity);
        bookDao.save(bookEntity);
    }

    @Override
    public void deleteBook(String bookId) {
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if (!foundBook.isPresent()) {
            throw new BookNotFoundException("Book not found");
        }

            bookDao.deleteById(bookId);


    }

    @Override
    public void updateBook(String bookId, BookDto bookDto) {
        System.out.println(bookId);
        System.out.println(bookDto);
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if(!foundBook.isPresent()){
            throw new BookNotFoundException("Book not found");
        }
        foundBook.get().setBookName(bookDto.getBookName());
        foundBook.get().setAuthor(bookDto.getAuthor());
        foundBook.get().setEdition(bookDto.getEdition());
        foundBook.get().setPublisher(bookDto.getPublisher());
        foundBook.get().setIsbn(bookDto.getIsbn());
        foundBook.get().setPrice(bookDto.getPrice());
        foundBook.get().setTotalQty(bookDto.getTotalQty());
        foundBook.get().setAvailableQty(bookDto.getAvailableQty());
        foundBook.get().setLastUpdateDate(UtilData.generateTodayDate());
        foundBook.get().setLastUpdateTime(UtilData.generatecurrentTime());
    }

    @Override
    public BookDto getSelectedBook(String bookId) {
        Optional<BookEntity> byId = bookDao.findById(bookId);
        if (!byId.isPresent()) {
            throw new BookNotFoundException("Selected Book not found");
        }
        BookEntity selectedBookEntity = bookDao.getReferenceById(bookId);
        BookDto selectedBookDto = entityDtoConvert.convertBookEntityToBookDto(selectedBookEntity);
        return selectedBookDto;
    }
    @Override
    public List<BookDto> getAllBooks() {
        return entityDtoConvert.toBookDtoList(bookDao.findAll());

    }
}
