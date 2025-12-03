package com.example.Midka;

import com.example.Midka.Dto.BookDto;
import com.example.Midka.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookServiceImpl bookService;

    @Test
    void getAllTest() {
        List<BookDto> bookDtoList = bookService.getAll();

        Assertions.assertNotNull(bookDtoList);
        Assertions.assertNotEquals(0, bookDtoList.size());


        for (BookDto bookDto : bookDtoList) {
            Assertions.assertNotNull(bookDto);
            Assertions.assertNotNull(bookDto.getId());
            Assertions.assertNotNull(bookDto.getName());
            Assertions.assertNotNull(bookDto.getGenre());
        }
    }

    @Test
    void getByIdTest() {
        Random random = new Random();
        List<BookDto> bookDtoList = bookService.getAll();
        int randomIndex = random.nextInt(bookDtoList.size());
        Long id = bookDtoList.get(randomIndex).getId();

        BookDto bookDto = bookService.getbyid(id);
        Assertions.assertNotNull(bookDto);
        Assertions.assertEquals(id, bookDto.getId());

        BookDto bookDto1 = bookService.getbyid(-1L);
        Assertions.assertNull(bookDto1);
    }

    @Test
    void addBookTest() {
        BookDto bookDto = new BookDto();
        bookDto.setName("Marvel");
        bookDto.setGenre("Fantactika");

        BookDto newbooks = bookService.addOne(bookDto);
        Assertions.assertNotNull(newbooks);
        Assertions.assertEquals(bookDto.getName(), newbooks.getName());
        Assertions.assertEquals(bookDto.getGenre(), newbooks.getGenre());

        BookDto bookDto1 = bookService.getbyid(newbooks.getId());
        Assertions.assertNotNull(bookDto1);
    }

    @Test
    void updateBookTest() {
        List<BookDto> bookDtoList = bookService.getAll();
        Random random = new Random();
        int randomIndex = random.nextInt(bookDtoList.size());
        Long id = bookDtoList.get(randomIndex).getId();

        BookDto bookDto = new BookDto();
        bookDto.setId(id);
        bookDto.setName("Marvel");
        bookDto.setGenre("Fantastika");

        BookDto updatedbook = bookService.update(id, bookDto);
        Assertions.assertNotNull(updatedbook);
        Assertions.assertEquals(bookDto.getName(), updatedbook.getName());
        Assertions.assertEquals(bookDto.getGenre(), updatedbook.getGenre());
    }

    @Test
    void deleteBookTest() {
        List<BookDto> bookDtoList = bookService.getAll();
        Random random = new Random();
        int randomIndex = random.nextInt(bookDtoList.size());
        Long id = bookDtoList.get(randomIndex).getId();

        Assertions.assertTrue(bookService.delete(id) > 0);
        Assertions.assertNull(bookService.getbyid(id));
    }
}
