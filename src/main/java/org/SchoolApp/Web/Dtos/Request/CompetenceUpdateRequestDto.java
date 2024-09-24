package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

import java.util.List;

@Data
public class CompetenceUpdateRequestDto {
    private Long id;  // Si la compétence existe, on peut passer son ID, sinon null pour en ajouter une nouvelle
    private String nom;
    private String description;
    private int dureeAcquisition;
    private String type;
    private boolean deleted = false; // Indique si la compétence doit être soft-deleted
    private List<ModuleUpdateRequestDto> modules;
}
