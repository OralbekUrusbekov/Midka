package com.example.Midka.Dto;

import com.example.Midka.model.Book;
import com.example.Midka.model.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private String name;
    private int course;
    private List<Book> books;
    private List<Group> groups;
}
