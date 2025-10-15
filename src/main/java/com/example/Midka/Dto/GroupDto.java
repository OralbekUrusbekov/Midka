package com.example.Midka.Dto;


import com.example.Midka.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private String name;
    private String type;
    private List<Student> students;
}
