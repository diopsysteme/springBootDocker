package org.SchoolApp.Services.Interfaces;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;
import java.util.List;

public interface ReferentielService {
    ReferentielEntity createReferentiel(ReferentielEntity referentiel);
    List<ReferentielEntity> listActiveReferentiels();
    ReferentielEntity updateReferentiel(Long id, ReferentielEntity referentiel);
    void deleteReferentiel(Long id);
    List<ReferentielEntity> listArchivedReferentiels();
    List<ReferentielEntity> listReferentielsByStatus(StatusReferenceEnum status);
    ReferentielEntity getReferentielById(Long id);
    ReferentielEntity updateReferentielWithDetails(Long id, ReferentielEntity referentiel);
}
