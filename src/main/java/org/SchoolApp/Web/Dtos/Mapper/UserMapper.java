package org.SchoolApp.Web.Dtos.Mapper;

import lombok.Data;
import lombok.Getter;
import org.SchoolApp.Datas.Entity.EmargementEntity;
import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Web.Dtos.Response.EmargementDto;
import org.SchoolApp.Web.Dtos.Response.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserMapper {


    UserDto toDto(UserEntity userEntity);
    // Add mapping from User to UserDto

    UserDto toUserDto(UserEntity user);
    UserEntity toEntity(UserDto userDto);
}
