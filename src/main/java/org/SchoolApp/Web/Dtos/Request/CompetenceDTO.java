package org.SchoolApp.Web.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetenceDTO {
    private String nom;
    private String description;
    private int duree_acquisition;
    private String type;
    private List<ModuleDTO> modules;
}
