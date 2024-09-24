package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModulesRepository extends SoftDeleteRepository<ModulesEntity, Long> {
    List<ModulesEntity> findByNom(String nom);
}
