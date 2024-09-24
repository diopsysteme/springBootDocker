package org.SchoolApp.Services.Interfaces;

import org.SchoolApp.Datas.Entity.ModulesEntity;

import java.util.List;

public interface ModulesService {
    List<ModulesEntity> getAllModules();
    ModulesEntity getModuleById(Long id);
    ModulesEntity createModule(ModulesEntity module);
    ModulesEntity updateModule(Long id, ModulesEntity module);
    void deleteModule(Long id);
}