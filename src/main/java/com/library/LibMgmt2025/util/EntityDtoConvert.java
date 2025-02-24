package com.library.LibMgmt2025.util;

import com.library.LibMgmt2025.dto.BookDto;
import com.library.LibMgmt2025.entity.BookEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EntityDtoConvert {
    private final ModelMapper modelMapper;

    //Book
    public BookEntity convertBookDtoToBookEntity(BookDto bookDto) {
        return modelMapper.map(bookDto, BookEntity.class);
    }
    public BookDto convertBookEntityToBookDto(BookEntity bookEntity) {
        return modelMapper.map(bookEntity, BookDto.class);
    }
    public List<BookDto> toBookDtoList(List<BookEntity> bookEntityList) {
        return modelMapper.map(bookEntityList,new TypeToken<List<BookDto>>(){}.getType());
    }
}
