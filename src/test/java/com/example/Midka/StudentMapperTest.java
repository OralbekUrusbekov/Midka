package com.example.Midka;

import com.example.Midka.Dto.BookDto;
import com.example.Midka.Dto.GroupDto;
import com.example.Midka.Dto.StudentDto;
import com.example.Midka.mapper.StudentMapper;
import com.example.Midka.model.Book;
import com.example.Midka.model.Group;
import com.example.Midka.model.Student;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class StudentMapperTest {

    private final StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);


    Book book1 = new Book(1L,"Motivation","The street Cat",null);
    Book book2 = new Book(2L,"Motivation2","The street Cat3",null);

    BookDto dtobook1 = new BookDto(1L,"Motivation","The street Cat");
    BookDto dtobook2 = new BookDto(2L,"Motivation2","The street Cat3");

    Group group1 = new Group(1L,"Ikt","Jaratylystanu",null);
    Group group2 = new Group(2L,"Math","Math",null);

    GroupDto dtogroup1 = new GroupDto(1L,"Ikt","Jaratylystanu",null);
    GroupDto dtogroup2 = new GroupDto(2L,"Math","Math",null);


    @Test
    void toDto(){

        Student student = new Student(1L, "Oralbek", 3, null, null);
        student.setBooks(List.of(book1,book2));
        student.setGroups(List.of(group1,group2));

        StudentDto studentDto = studentMapper.toDto(student);


        assertEquals(student.getId(),studentDto.getId());
        assertEquals(student.getName(),studentDto.getName());
        assertEquals(student.getCourse(),studentDto.getCourse());

        for(int s = 0; s < List.of(book2, book1).size(); s++){
            assertEquals(studentDto.getBooks().get(s).getName(),student.getBooks().get(s).getName());
            assertEquals(studentDto.getBooks().get(s).getId(),student.getBooks().get(s).getId());
            assertEquals(studentDto.getBooks().get(s).getGenre(),student.getBooks().get(s).getGenre());

        }

        for (int s = 0; s < student.getGroups().size(); s++) {
            assertEquals(studentDto.getGroups().get(s).getName(), student.getGroups().get(s).getName());
            assertEquals(studentDto.getGroups().get(s).getType(), student.getGroups().get(s).getType());
            assertNull(studentDto.getGroups().get(s).getStudents());
        }

    }

    @Test
    void toEntity(){

        StudentDto studentDto = new StudentDto(1L, "Oralbek", 3, null, null);
        studentDto.setBooks(List.of(dtobook1,dtobook2));
        studentDto.setGroups(List.of(dtogroup1,dtogroup2));

        Student student = studentMapper.toEntity(studentDto);

        assertEquals(student.getId(),studentDto.getId());
        assertEquals(student.getName(),studentDto.getName());
        assertEquals(student.getCourse(),studentDto.getCourse());


        for(int s = 0; s < studentDto.getBooks().size(); s++){
            assertEquals(studentDto.getBooks().get(s).getName(),student.getBooks().get(s).getName());
            assertEquals(studentDto.getBooks().get(s).getId(),student.getBooks().get(s).getId());
            assertEquals(studentDto.getBooks().get(s).getGenre(),student.getBooks().get(s).getGenre());
            assertNull(student.getBooks().get(s).getStudent());
        }

        for (int s = 0; s < student.getGroups().size(); s++) {
            assertEquals(studentDto.getGroups().get(s).getName(), student.getGroups().get(s).getName());
            assertEquals(studentDto.getGroups().get(s).getType(), student.getGroups().get(s).getType());
            assertNull(student.getGroups().get(s).getStudents());
        }

    }

    @Test
    void toEntityList() {

        StudentDto studentDto1 = new StudentDto(1L, "Oralbek", 3, null, null);
        StudentDto studentDto2 = new StudentDto(1L, "Teacher", 3, null, null);

        studentDto1.setBooks(List.of(dtobook1, dtobook2));
        studentDto1.setGroups(List.of(dtogroup1, dtogroup2));

        studentDto2.setBooks(List.of(dtobook1, dtobook2));
        studentDto2.setGroups(List.of(dtogroup1, dtogroup2));

        List<StudentDto> studentDtoList = List.of(studentDto1,studentDto2);
        List<Student> studentlist = studentMapper.toEntityList(studentDtoList);


        for (int a = 0; a < studentlist.size(); a++) {

            assertEquals(studentlist.get(a).getId(),studentDtoList.get(a).getId());
            assertEquals(studentlist.get(a).getCourse(),studentDtoList.get(a).getCourse());
            assertEquals(studentlist.get(a).getName(),studentDtoList.get(a).getName());



            for (int s = 0; s < studentDtoList.get(a).getBooks().size(); s++) {
                assertEquals(studentDtoList.get(a).getBooks().get(s).getName(), studentlist.get(a).getBooks().get(s).getName());
                assertEquals(studentDtoList.get(a).getBooks().get(s).getId(), studentlist.get(a).getBooks().get(s).getId());
                assertEquals(studentDtoList.get(a).getBooks().get(s).getGenre(), studentlist.get(a).getBooks().get(s).getGenre());
                assertNull(studentlist.get(a).getBooks().get(s).getStudent());
            }

            for (int s = 0; s < studentDtoList.get(a).getGroups().size(); s++) {
                assertEquals(studentDtoList.get(a).getGroups().get(s).getName(), studentlist.get(a).getGroups().get(s).getName());
                assertEquals(studentDtoList.get(a).getGroups().get(s).getType(), studentlist.get(a).getGroups().get(s).getType());
                assertNull(studentlist.get(a).getGroups().get(s).getStudents());
            }

        }
    }


    @Test
    void toDtoList() {

        Student student1 = new Student(1L, "Oralbek", 3, null, null);
        Student student2 = new Student(2L, "Teacher", 3, null, null);

        student1.setBooks(List.of(book1, book2));
        student1.setGroups(List.of(group1, group2));

        student2.setBooks(List.of(book1, book2));
        student2.setGroups(List.of(group1, group2));

        List<Student> studentlist = List.of(student1,student2);
        List<StudentDto> studentDtoList = studentMapper.toDtoList(studentlist);


        for (int a = 0; a < studentlist.size(); a++) {

            assertEquals(studentlist.get(a).getId(),studentDtoList.get(a).getId());
            assertEquals(studentlist.get(a).getCourse(),studentDtoList.get(a).getCourse());
            assertEquals(studentlist.get(a).getName(),studentDtoList.get(a).getName());



            for (int s = 0; s < studentlist.get(a).getBooks().size(); s++) {
                assertEquals(studentDtoList.get(a).getBooks().get(s).getName(), studentlist.get(a).getBooks().get(s).getName());
                assertEquals(studentDtoList.get(a).getBooks().get(s).getId(), studentlist.get(a).getBooks().get(s).getId());
                assertEquals(studentDtoList.get(a).getBooks().get(s).getGenre(), studentlist.get(a).getBooks().get(s).getGenre());
            }

            for (int s = 0; s < studentlist.get(a).getGroups().size(); s++) {
                assertEquals(studentDtoList.get(a).getGroups().get(s).getName(), studentlist.get(a).getGroups().get(s).getName());
                assertEquals(studentDtoList.get(a).getGroups().get(s).getType(), studentlist.get(a).getGroups().get(s).getType());
                assertNull(studentDtoList.get(a).getGroups().get(s).getStudents());
            }

        }
    }




}
