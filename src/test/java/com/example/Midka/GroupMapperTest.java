package com.example.Midka;

import com.example.Midka.Dto.GroupDto;
import com.example.Midka.Dto.StudentDto;
import com.example.Midka.mapper.GroupMapper;
import com.example.Midka.model.Group;
import com.example.Midka.model.Student;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GroupMapperTest {
    private final GroupMapper groupMapper = Mappers.getMapper(GroupMapper.class);

    Student student1 = new Student(1L, "Oralbek", 3, null, null);
    Student student2 = new Student(2L, "Teacher", 3, null, null);


    StudentDto dtostudent1 = new StudentDto(1L, "Oralbek2", 3, null, null);
    StudentDto dtostudent2 = new StudentDto(4L, "Teacher2", 3, null, null);



    @Test
    void todto(){

        Group group = new Group(1L,"Ikt","Jaratylystanu",List.of(student1,student2));

        GroupDto groupDto = groupMapper.toDto(group);

        assertEquals(groupDto.getName(),group.getName());
        assertEquals(groupDto.getType(),group.getType());
        assertEquals(groupDto.getId(),group.getId());


        for(int s = 0; s < group.getStudents().size(); s ++){
            assertEquals(groupDto.getStudents().get(s).getName(),group.getStudents().get(s).getName());
            assertEquals(groupDto.getStudents().get(s).getId(),group.getStudents().get(s).getId());
            assertEquals(groupDto.getStudents().get(s).getCourse(),group.getStudents().get(s).getCourse());
        }

    }

    @Test
    void toEntity(){

        GroupDto groupDto = new GroupDto(1L,"Ikt","Jaratylystanu",List.of(dtostudent1,dtostudent2));

        Group group = groupMapper.toEntity(groupDto);

        assertEquals(groupDto.getName(),group.getName());
        assertEquals(groupDto.getType(),group.getType());
        assertEquals(groupDto.getId(),group.getId());

        for(int s = 0; s < group.getStudents().size(); s ++){
            assertEquals(groupDto.getStudents().get(s).getName(),group.getStudents().get(s).getName());
            assertEquals(groupDto.getStudents().get(s).getId(),group.getStudents().get(s).getId());
            assertEquals(groupDto.getStudents().get(s).getCourse(),group.getStudents().get(s).getCourse());
        }

    }


    @Test
    void toEntityList(){

        GroupDto groupDto2 = new GroupDto(1L,"Ikt","Jaratylystanu",List.of(dtostudent1,dtostudent2));
        GroupDto groupDto1 = new GroupDto(2L,"Math","Math",List.of(dtostudent1,dtostudent2));

        List<GroupDto> groupDtoList  = List.of(groupDto1,groupDto2);
        List<Group> groupList = groupMapper.toEntityList(groupDtoList);

        for(int a = 0; a < groupDtoList.size(); a++){

            assertEquals(groupDtoList.get(a).getName(),groupList.get(a).getName());
            assertEquals(groupDtoList.get(a).getType(),groupList.get(a).getType());
            assertEquals(groupDtoList.get(a).getId(),groupList.get(a).getId());

            for(int s = 0; s < groupDtoList.get(a).getStudents().size(); s ++){
                assertEquals(groupDtoList.get(a).getStudents().get(s).getName(),groupList.get(a).getStudents().get(s).getName());
                assertEquals(groupDtoList.get(a).getStudents().get(s).getId(),groupList.get(a).getStudents().get(s).getId());
                assertEquals(groupDtoList.get(a).getStudents().get(s).getCourse(),groupList.get(a).getStudents().get(s).getCourse());
            }
        }


    }

    @Test
    void toDtoList(){

        Group group2 = new Group(1L,"Ikt","Jaratylystanu",List.of(student1,student2));
        Group group1 = new Group(2L,"Math","Math",List.of(student1,student2));

        List<Group> groupList  = List.of(group1,group2);
        List<GroupDto> groupDtoList = groupMapper.toDtoList(groupList);

        for(int a = 0; a < groupList.size(); a++){

            assertEquals(groupDtoList.get(a).getName(),groupList.get(a).getName());
            assertEquals(groupDtoList.get(a).getType(),groupList.get(a).getType());
            assertEquals(groupDtoList.get(a).getId(),groupList.get(a).getId());

            for(int s = 0; s < groupDtoList.get(a).getStudents().size(); s ++){
                assertEquals(groupDtoList.get(a).getStudents().get(s).getName(),groupList.get(a).getStudents().get(s).getName());
                assertEquals(groupDtoList.get(a).getStudents().get(s).getId(),groupList.get(a).getStudents().get(s).getId());
                assertEquals(groupDtoList.get(a).getStudents().get(s).getCourse(),groupList.get(a).getStudents().get(s).getCourse());
            }
        }


    }
}

