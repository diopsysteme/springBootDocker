package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Web.Dtos.Request.ModuleRequest;
import org.SchoolApp.Web.Dtos.Request.ModuleRequestDto;
import org.SchoolApp.Web.Dtos.Response.ModuleResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuleMappper {
    ModulesEntity toEntity(ModuleRequestDto moduleRequestDto);

    ModuleResponseDto toDto(ModulesEntity modulesEntity);
}
