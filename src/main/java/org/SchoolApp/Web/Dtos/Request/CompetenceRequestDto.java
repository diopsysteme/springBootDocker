package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

import java.util.List;

@Data
public class CompetenceRequestDto {
    private String nom;
    private String description;
    private int dureeAcquisition;
    private String type;
    private List<ModuleRequestDto> modules;
}
