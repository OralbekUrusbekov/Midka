package com.example.Midka.mapper;

import com.example.Midka.Dto.BookDto;
import org.mapstruct.Mapper;


import com.example.Midka.model.Book;
import java.util.List;

@Mapper(componentModel = "spring",uses={StudentMapper.class})
public interface BookMapper {
    BookDto toDto(Book book);
    Book toEntity(BookDto bookDto);

    List<BookDto> toDtoList(List<Book> bookList);

}
