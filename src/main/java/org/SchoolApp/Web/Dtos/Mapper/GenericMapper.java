package org.SchoolApp.Web.Dtos.Mapper;

import org.mapstruct.Mapper;

public interface GenericMapper<D, E> {
    D toDto(E entity);
    E toEntity(D dto);
}
