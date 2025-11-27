package com.example.Midka.service;

import com.example.Midka.Dto.GroupDto;
import java.util.List;

public interface GroupService {

    List<GroupDto> getAll();               // Барлық топтар

    GroupDto getbyid(Long id);

    GroupDto addOne(GroupDto dto);         // Топ қосу
    GroupDto update(Long id, GroupDto dto);// Топты жаңарту
    void delete(Long id);                  // Топты өшіру
}
