package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Web.Dtos.Request.ReferentielRequestDto;
import org.SchoolApp.Web.Dtos.Request.ReferentielUpdateRequestDto;  // Ajout pour la mise à jour
import org.SchoolApp.Web.Dtos.Response.ReferentielResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReferentielMapper {

    ReferentielEntity toEntity(ReferentielRequestDto referentielRequestDto);

    ReferentielResponseDto toDto(ReferentielEntity referentielEntity);

    ReferentielEntity toEntity(ReferentielUpdateRequestDto referentielUpdateRequestDto);  // Pour les mises à jour
}
