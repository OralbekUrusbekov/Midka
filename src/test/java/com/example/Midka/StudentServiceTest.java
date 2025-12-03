package com.example.Midka;

import com.example.Midka.Dto.StudentDto;
import com.example.Midka.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class StudentServiceTest {

   @Autowired
    private  StudentServiceImpl studentService;



    @Test
    void getAllTest() {
        List<StudentDto> studentDtoList = studentService.getAll();
        Assertions.assertNotNull(studentDtoList);
        Assertions.assertNotEquals(0, studentDtoList.size());

        for (StudentDto studentDto : studentDtoList) {
            Assertions.assertNotNull(studentDto);
            Assertions.assertNotNull(studentDto.getId());
            Assertions.assertNotNull(studentDto.getName());
        }
    }

    @Test
    void getByIdTest() {
        List<StudentDto> studentDtoList = studentService.getAll();
        Random random = new Random();
        int randomIndex = random.nextInt(studentDtoList.size());
        Long id = studentDtoList.get(randomIndex).getId();

        StudentDto studentDto = studentService.findbyid(id);
        Assertions.assertNotNull(studentDto);
        Assertions.assertEquals(id, studentDto.getId());

        StudentDto studentDto1 = studentService.findbyid(-1L);
        Assertions.assertNull(studentDto1);
    }

    @Test
    void addStudentTest() {
        StudentDto studentDto = new StudentDto();
        studentDto.setName("Oralbek");
        studentDto.setCourse(3);

        StudentDto student = studentService.addOne(studentDto);
        Assertions.assertNotNull(student);
        Assertions.assertEquals(studentDto.getName(), student.getName());
        Assertions.assertEquals(studentDto.getCourse(), student.getCourse());

        StudentDto studentDto1 = studentService.findbyid(student.getId());
        Assertions.assertNotNull(studentDto1);
    }

    @Test
    void updateStudentTest() {
        List<StudentDto> studentDtoList = studentService.getAll();
        Random random = new Random();
        int randomIndex = random.nextInt(studentDtoList.size());
        Long id = studentDtoList.get(randomIndex).getId();

        StudentDto studentDto = new StudentDto();
        studentDto.setId(id);
        studentDto.setName("Oralbek");
        studentDto.setCourse(3);

        StudentDto studentDtoupdate = studentService.update(id, studentDto);
        Assertions.assertNotNull(studentDtoupdate);
        Assertions.assertEquals(studentDto.getName(), studentDtoupdate.getName());
        Assertions.assertEquals(studentDto.getCourse(), studentDtoupdate.getCourse());
    }

    @Test
    void deleteStudentTest() {
        List<StudentDto> studentDtoList = studentService.getAll();
        Random random = new Random();
        int randomIndex = random.nextInt(studentDtoList.size());
        Long id = studentDtoList.get(randomIndex).getId();

        Assertions.assertTrue(studentService.delete(id) > 0);

        StudentDto deletedstudent = studentService.findbyid(id);
        Assertions.assertNull(deletedstudent);
    }
}
