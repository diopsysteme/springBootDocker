package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.CompetencesEntity;
import org.SchoolApp.Web.Dtos.Request.CompetenceRequest;
import org.SchoolApp.Web.Dtos.Request.CompetenceRequestDto;
import org.SchoolApp.Web.Dtos.Response.CompetenceResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompetenceMapper {
    CompetencesEntity toEntity(CompetenceRequestDto competenceRequestDto);

    CompetenceResponseDto toDto(CompetencesEntity competencesEntity);
}
