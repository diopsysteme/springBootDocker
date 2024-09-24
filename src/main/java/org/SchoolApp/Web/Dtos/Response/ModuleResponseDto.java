package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;

@Data
public class ModuleResponseDto {
    private Long id;
    private String nom;
    private String description;
    private int dureeAcquisition;
}
