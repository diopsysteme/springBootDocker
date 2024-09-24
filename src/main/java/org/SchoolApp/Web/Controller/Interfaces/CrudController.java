package org.SchoolApp.Web.Controller.Interfaces;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface CrudController<Entity,dto,dtoUpdae> {
    Entity Create(dto dto);
    Entity Update(Long id,dtoUpdae dto);
    List<Entity> findAll();
    Optional<Entity> findById(Long id);
}
