package com.example.Midka.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="books")
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @ManyToMany
    @JoinTable(name = "group_students",
    joinColumns = @JoinColumn(name="group_id"),
    inverseJoinColumns = @JoinColumn(name="student_id"))
    private List<Student> students;

}
