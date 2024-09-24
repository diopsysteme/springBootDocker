package org.SchoolApp.Services.Interfaces;

import org.SchoolApp.Datas.Entity.Fonction;

import java.util.List;

public interface FonctionService {
    List<Fonction> getAllFonctions();
    Fonction getFonctionById(Long id);
    Fonction createFonction(Fonction fonction);
    Fonction updateFonction(Long id, Fonction fonction);
    void deleteFonction(Long id);
}
