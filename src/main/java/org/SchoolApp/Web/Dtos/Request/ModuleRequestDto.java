package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

@Data
public class ModuleRequestDto {
    private String nom;
    private String description;
    private int dureeAcquisition;
}
