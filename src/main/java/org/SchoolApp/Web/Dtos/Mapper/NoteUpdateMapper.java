package org.SchoolApp.Web.Dtos.Mapper;

import org.SchoolApp.Datas.Entity.NotesEntity;
import org.SchoolApp.Web.Dtos.Request.NoteUpdate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NoteUpdateMapper {
    NoteUpdate toDto(NotesEntity entity);

    NotesEntity toEntity(NoteUpdate dto);

    List<NoteUpdate> toDtoList(List<NotesEntity> entities);

    List<NotesEntity> toEntityList(List<NoteUpdate> dtos);

    // Change return type to NotesEntity
    NotesEntity updateEntityFromDto(NoteUpdate dto, @MappingTarget NotesEntity entity);
}
