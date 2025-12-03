package com.example.Midka;

import com.example.Midka.Dto.GroupDto;
import com.example.Midka.service.impl.GroupServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class GroupServiceTest {

    @Autowired
    private GroupServiceImpl groupService;

    @Test
    void getAllTest() {
        List<GroupDto> groupDtoList = groupService.getAll();
        Assertions.assertNotNull(groupDtoList);
        Assertions.assertNotEquals(0, groupDtoList.size());

        for (GroupDto groupDto : groupDtoList) {
            Assertions.assertNotNull(groupDto);
            Assertions.assertNotNull(groupDto.getId());
            Assertions.assertNotNull(groupDto.getName());
            Assertions.assertNotNull(groupDto.getType());
        }
    }

    @Test
    void getByIdTest() {
        List<GroupDto> groupDtoList = groupService.getAll();
        Random random = new Random();
        int randomIndex = random.nextInt(groupDtoList.size());
        Long id = groupDtoList.get(randomIndex).getId();

        GroupDto groupDto = groupService.getbyid(id);
        Assertions.assertNotNull(groupDto);
        Assertions.assertEquals(id, groupDto.getId());
    }

    @Test
    void addGroupTest() {
        GroupDto groupDto = new GroupDto();
        groupDto.setName("Best");
        groupDto.setType("Hr");

        GroupDto newgroup = groupService.addOne(groupDto);
        Assertions.assertNotNull(newgroup);
        Assertions.assertEquals(groupDto.getName(), newgroup.getName());
        Assertions.assertEquals(groupDto.getType(), newgroup.getType());

        GroupDto fetched = groupService.getbyid(newgroup.getId());
        Assertions.assertNotNull(fetched);
    }

    @Test
    void updateGroupTest() {
        List<GroupDto> groupDtoList = groupService.getAll();
        Random random = new Random();
        int randomIndex = random.nextInt(groupDtoList.size());
        Long id = groupDtoList.get(randomIndex).getId();

        GroupDto groupDto = new GroupDto();
        groupDto.setId(id);
        groupDto.setName("Oralbek");
        groupDto.setType("Oralbek");

        GroupDto updatedgroup = groupService.update(id, groupDto);
        Assertions.assertNotNull(updatedgroup);
        Assertions.assertEquals(groupDto.getName(), updatedgroup.getName());
        Assertions.assertEquals(groupDto.getType(), updatedgroup.getType());
    }

    @Test
    void deleteGroupTest() {
        List<GroupDto> groupDtoList = groupService.getAll();
        Random random = new Random();
        int randomIndex = random.nextInt(groupDtoList.size());
        Long id = groupDtoList.get(randomIndex).getId();

        groupService.delete(id);

        GroupDto deletedgroup = groupService.getbyid(id);
        Assertions.assertNull(deletedgroup);
    }
}
