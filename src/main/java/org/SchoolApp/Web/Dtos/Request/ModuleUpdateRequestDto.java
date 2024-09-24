package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

@Data
public class ModuleUpdateRequestDto {
    private Long id;  // Si le module existe, son ID sera fourni, sinon null pour en ajouter un nouveau
    private String nom;
    private String description;
    private int dureeAcquisition;
    private boolean deleted = false; // Indique si le module doit être soft-deleted
}
