package org.SchoolApp.Datas.Repository;

import org.SchoolApp.Datas.Entity.Fonction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FonctionRepository extends SoftDeleteRepository<Fonction, Long> {
    List<Fonction> findByLibelle(String libelle);
}
