package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;

import java.util.List;

@Data
public class CompetenceResponseDto {
    private Long id;
    private String nom;
    private String description;
    private int dureeAcquisition;
    private String type;
    private List<ModuleResponseDto> modules;
}
