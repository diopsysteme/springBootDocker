package org.SchoolApp.Web.Dtos.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleDTO {
    private String nom;
    private String description;
    private int duree_acquisition;
}
