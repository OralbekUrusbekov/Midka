package com.example.Midka.service.impl;

import com.example.Midka.Dto.StudentDto;
import com.example.Midka.mapper.StudentMapper;
import com.example.Midka.model.Book;
import com.example.Midka.model.Student;
import com.example.Midka.repositories.StudentRepository;
import com.example.Midka.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDto> getAll() {
        return studentMapper.toDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDto addOne(StudentDto dto) {
        return studentMapper.toDto(studentRepository.save(studentMapper.toEntity(dto)));
    }

    @Override
    public StudentDto update(Long id, StudentDto dto) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setName(dto.getName());
            return studentMapper.toDto(studentRepository.save(student));
        }
        return null;
    }

    @Override
    public int delete(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if(student != null){
            studentRepository.delete(student);
        }
        return Math.toIntExact(student.getId());
    }
}
