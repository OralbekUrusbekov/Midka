package com.example.Midka.mapper;

import com.example.Midka.Dto.BookDto;
import com.example.Midka.Dto.StudentDto;
import com.example.Midka.model.Student;
import org.mapstruct.Mapper;

import java.awt.print.Book;
import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student book);
    Student toEntity(StudentDto bookDto);

    List<StudentDto> toDtoList(List<Student> bookList);

}