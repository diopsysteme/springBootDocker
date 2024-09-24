package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

@Data
public class ModuleRequest {
    private String description;
    private int dureeAcquisition;
    private String nom;
}
