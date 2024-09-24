package org.SchoolApp.Services.Impl;

import org.SchoolApp.Datas.Entity.ModulesEntity;
import org.SchoolApp.Services.Interfaces.ModulesService;
import org.SchoolApp.Datas.Repository.ModulesRepository;
import org.SchoolApp.Datas.Repository.SoftDeleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulesServiceImpl implements ModulesService {

    @Autowired
    private ModulesRepository modulesRepository;

    @Autowired
    private SoftDeleteRepository<ModulesEntity, Long> softDeleteRepository;

    @Override
    public List<ModulesEntity> getAllModules() {
        return modulesRepository.findAll();
    }

    @Override
    public ModulesEntity getModuleById(Long id) {
        return modulesRepository.findById(id).orElseThrow(() -> new RuntimeException("Module not found"));
    }

    @Override
    public ModulesEntity createModule(ModulesEntity module) {
        return modulesRepository.save(module);
    }

    @Override
    public ModulesEntity updateModule(Long id, ModulesEntity module) {
        ModulesEntity existingModule = modulesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Module not found"));
        existingModule.setNom(module.getNom());
        existingModule.setDescription(module.getDescription());
        existingModule.setDuree_acquisition(module.getDuree_acquisition());
        return modulesRepository.save(existingModule);
    }

    @Override
    public void deleteModule(Long id) {
        softDeleteRepository.softDelete(id);
    }
}