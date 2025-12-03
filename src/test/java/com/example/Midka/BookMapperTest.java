package com.example.Midka;

import com.example.Midka.Dto.BookDto;
import com.example.Midka.mapper.BookMapper;
import com.example.Midka.model.Book;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookMapperTest {

    private final BookMapper bookMapper = Mappers.getMapper(BookMapper.class);


    @Test
    void toDto(){
        Book book = new Book();
        book.setId(1L);
        book.setGenre("Motimation");
        book.setName("The street cat");

        BookDto bookDto = bookMapper.toDto(book);

        assertEquals(book.getId(),bookDto.getId());
        assertEquals(book.getName(),bookDto.getName());
        assertEquals(book.getGenre(),bookDto.getGenre());


    }

    @Test
    void toEntity(){
        BookDto bookDto = new BookDto();
        bookDto.setId(1L);
        bookDto.setGenre("Motimation");
        bookDto.setName("The street cat");

        Book book = bookMapper.toEntity(bookDto);

        assertEquals(book.getId(),bookDto.getId());
        assertEquals(book.getName(),bookDto.getName());
        assertEquals(book.getGenre(),bookDto.getGenre());
    }

    @Test
    void toEntityList(){
        BookDto bookDto = new BookDto();
        bookDto.setId(1L);
        bookDto.setGenre("Motimation");
        bookDto.setName("The street cat");

        BookDto bookDto1 = new BookDto();
        bookDto1.setId(2L);
        bookDto1.setGenre("Motimation2");
        bookDto1.setName("The street cat2");

        List<Book> entitylist = bookMapper.toEntityList(List.of(bookDto,bookDto1));

        assertEquals(2,entitylist.size());
        assertEquals(bookDto.getName(),entitylist.get(0).getName());
        assertEquals(bookDto.getId(),entitylist.get(0).getId());
        assertEquals(bookDto.getGenre(),entitylist.get(0).getGenre());


        assertEquals(bookDto1.getName(),entitylist.get(1).getName());
        assertEquals(bookDto1.getId(),entitylist.get(1).getId());
        assertEquals(bookDto1.getGenre(),entitylist.get(1).getGenre());
    }


    @Test
    void toDtoList(){
        Book book = new Book();
        book.setId(1L);
        book.setGenre("Motimation");
        book.setName("The street cat");

        Book book1 = new Book();
        book1.setId(2L);
        book1.setGenre("Motimation2");
        book1.setName("The street cat2");

        List<BookDto> dtoList = bookMapper.toDtoList(List.of(book,book1));

        assertEquals(2,dtoList.size());
        assertEquals(book.getName(),dtoList.get(0).getName());
        assertEquals(book.getId(),dtoList.get(0).getId());
        assertEquals(book.getGenre(),dtoList.get(0).getGenre());


        assertEquals(book1.getName(),dtoList.get(1).getName());
        assertEquals(book1.getId(),dtoList.get(1).getId());
        assertEquals(book1.getGenre(),dtoList.get(1).getGenre());
    }




}
