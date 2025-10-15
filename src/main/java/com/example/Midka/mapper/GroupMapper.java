package com.example.Midka.mapper;

import com.example.Midka.Dto.GroupDto;
import com.example.Midka.model.Group;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spting")
public interface GroupMapper {
    GroupDto toDto(Group group);
    Group toEntity(GroupDto groupDto);
    List<GroupDto> toDtoList(List<Group> groupList);

}