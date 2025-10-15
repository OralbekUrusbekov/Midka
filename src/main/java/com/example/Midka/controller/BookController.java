package com.example.Midka.controller;


import com.example.Midka.Dto.BookDto;
import com.example.Midka.service.impl.BookServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class BookController {

    private final BookServiceImpl bookServiceImls;

    @GetMapping()
    private ResponseEntity<List<BookDto>> getall(){
        return ResponseEntity.ok(bookServiceImls.getAll());
    }
    @PostMapping()
    private ResponseEntity<BookDto> add(@RequestBody BookDto bookDto){
        return ResponseEntity.ok((bookServiceImls.addOne(bookDto)));
    }

    @PutMapping("/{id}")
    private ResponseEntity<BookDto> update(@PathVariable Long id, @RequestBody BookDto bookDto){
        return ResponseEntity.ok(bookServiceImls.update(id, bookDto));
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Integer> delete(@PathVariable Long id){
        return ResponseEntity.ok(bookServiceImls.delete(id));
    }
}
