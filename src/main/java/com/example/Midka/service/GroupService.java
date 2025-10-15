package com.example.Midka.service;

import com.example.Midka.Dto.BookDto;
import com.example.Midka.Dto.GroupDto;

public interface GroupService {
    GroupDto getAll();
    GroupDto addOne(BookDto dto);
    GroupDto update(Long id, GroupDto dto);
    void delete(Long id);
}
