package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.Fonction;
import org.SchoolApp.Services.Interfaces.FonctionService;
import org.SchoolApp.Datas.Repository.FonctionRepository;
import org.SchoolApp.Datas.Repository.SoftDeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FonctionServiceImpl implements FonctionService {

    @Autowired
    private FonctionRepository fonctionRepository;

    @Autowired
    private SoftDeleteRepository<Fonction, Long> softDeleteRepository;

    @Override
    public List<Fonction> getAllFonctions() {
        return fonctionRepository.findAll();
    }

    @Override
    public Fonction getFonctionById(Long id) {
        return fonctionRepository.findById(id).orElseThrow(() -> new RuntimeException("Fonction not found"));
    }

    @Override
    public Fonction createFonction(Fonction fonction) {
        return fonctionRepository.save(fonction);
    }

    @Override
    public Fonction updateFonction(Long id, Fonction fonction) {
        Fonction existingFonction = fonctionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fonction not found"));
        existingFonction.setLibelle(fonction.getLibelle());
        existingFonction.setDescription(fonction.getDescription());
        return fonctionRepository.save(existingFonction);
    }

    @Override
    public void deleteFonction(Long id) {
        softDeleteRepository.softDelete(id);
    }
}