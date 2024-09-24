package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.CompetencesEntity;
import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;
import org.SchoolApp.Datas.Repository.ModulesRepository;
import org.SchoolApp.Datas.Repository.ReferentielRepository;
import org.SchoolApp.Services.Interfaces.ReferentielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.SchoolApp.Datas.Repository.CompetencesRepository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@Transactional
public class ReferentielServiceImpl implements ReferentielService {

    @Autowired
    private ReferentielRepository referentielRepository;

    @Autowired
    private CompetencesRepository competencesRepository;

    @Autowired
    private ModulesRepository modulesRepository;

    @Override
    public ReferentielEntity createReferentiel(ReferentielEntity referentiel) {
        if (referentiel.getCompetences() != null) {
            referentiel.getCompetences().forEach(competence -> {
                if (competence.getId() == null) {
                    competence.getModules().forEach(module -> {
                        if (module.getId() == null) {
                            modulesRepository.save(module);
                        }
                    });
                    competencesRepository.save(competence);
                }
            });
        }
        return referentielRepository.save(referentiel);
    }


    @Override
    public List<ReferentielEntity> listActiveReferentiels() {
        return referentielRepository.findByStatus(StatusReferenceEnum.Actif);
    }

    @Override
    public List<ReferentielEntity> listReferentielsByStatus(StatusReferenceEnum status) {
        return referentielRepository.findByStatus(status);
    }


    @Override
    public ReferentielEntity updateReferentiel(Long id, ReferentielEntity referentielUpdates) {
        ReferentielEntity referentiel = referentielRepository.findById(id).orElseThrow(() -> new RuntimeException("Referentiel not found"));
        if (referentielUpdates.getLibelle() != null) referentiel.setLibelle(referentielUpdates.getLibelle());
        if (referentielUpdates.getCode() != null) referentiel.setCode(referentielUpdates.getCode());
        if (referentielUpdates.getDescription() != null) referentiel.setDescription(referentielUpdates.getDescription());
        if (referentielUpdates.getPhoto_couverture() != null) referentiel.setPhoto_couverture(referentielUpdates.getPhoto_couverture());
        referentiel.setCompetences(referentielUpdates.getCompetences());
        return referentielRepository.save(referentiel);
    }


    @Override
    public void deleteReferentiel(Long id) {
        ReferentielEntity referentiel = referentielRepository.findById(id).orElseThrow(() -> new RuntimeException("Referentiel not found"));
        referentiel.setDeleted(true);
        referentielRepository.save(referentiel);
    }

    @Override
    public List<ReferentielEntity> listArchivedReferentiels() {
        return referentielRepository.findByDeletedTrue();
    }

    @Override
    public ReferentielEntity getReferentielById(Long id) {
        return referentielRepository.findById(id).orElse(null);
    }

    @Override
    public ReferentielEntity updateReferentielWithDetails(Long id, ReferentielEntity updates) {
        ReferentielEntity existing = referentielRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Referentiel not found"));

        // Mise à jour des informations de base
        if (updates.getLibelle() != null) {
            existing.setLibelle(updates.getLibelle());
        }
        if (updates.getDescription() != null) {
            existing.setDescription(updates.getDescription());
        }

        // Gestion des compétences et modules
        handleCompetenciesAndModules(existing, updates);

        return referentielRepository.save(existing);
    }

    private void handleCompetenciesAndModules(ReferentielEntity existing, ReferentielEntity updates) {
        Map<Long, CompetencesEntity> existingCompetencesMap = existing.getCompetences().stream()
                .collect(Collectors.toMap(CompetencesEntity::getId, Function.identity()));

        for (CompetencesEntity updatedCompetence : updates.getCompetences()) {
            CompetencesEntity existingCompetence = existingCompetencesMap.get(updatedCompetence.getId());

            if (updatedCompetence.isDeleted()) {
                // Supprimer la compétence et ses modules en soft delete
                existing.getCompetences().remove(existingCompetence);
                competencesRepository.softDelete(existingCompetence.getId());
                for (ModulesEntity module : existingCompetence.getModules()) {
                    modulesRepository.softDelete(module.getId());  // Supprime les modules de cette compétence
                }
            } else if (existingCompetence != null) {
                // Mise à jour de la compétence existante
                updateExistingCompetence(existingCompetence, updatedCompetence);
            } else {
                // Ajouter une nouvelle compétence
                competencesRepository.save(updatedCompetence);
                existing.getCompetences().add(updatedCompetence);
            }
        }
    }

    private void updateExistingCompetence(CompetencesEntity existing, CompetencesEntity updated) {
        existing.setNom(updated.getNom());
        existing.setDescription(updated.getDescription());
        existing.setDuree_acquisition(updated.getDuree_acquisition());
        existing.setType(updated.getType());

        // Gestion des modules de la compétence
        handleModules(existing, updated);
    }

    private void handleModules(CompetencesEntity existingCompetence, CompetencesEntity updatedCompetence) {
        Map<Long, ModulesEntity> existingModulesMap = existingCompetence.getModules().stream()
                .collect(Collectors.toMap(ModulesEntity::getId, Function.identity()));

        for (ModulesEntity updatedModule : updatedCompetence.getModules()) {
            ModulesEntity existingModule = existingModulesMap.get(updatedModule.getId());

            if (updatedModule.isDeleted()) {
                existingCompetence.getModules().remove(existingModule);
                modulesRepository.softDelete(existingModule.getId());
            } else if (existingModule != null) {
                existingModule.setNom(updatedModule.getNom());
                existingModule.setDescription(updatedModule.getDescription());
                existingModule.setDuree_acquisition(updatedModule.getDuree_acquisition());
            } else {
                modulesRepository.save(updatedModule);
                existingCompetence.getModules().add(updatedModule);
            }
        }
    }


}
