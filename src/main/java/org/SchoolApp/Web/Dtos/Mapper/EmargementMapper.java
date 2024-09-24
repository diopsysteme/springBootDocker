package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.EmargementEntity;
import org.SchoolApp.Web.Dtos.Response.EmargementDto;
import org.mapstruct.Mapper;
import org.springframework.web.bind.annotation.Mapping;
@Mapper(componentModel = "spring")
public interface EmargementMapper {
    EmargementDto toDto(EmargementEntity emargementEntity);

    EmargementEntity toEntity(EmargementDto emargementDto);
}
