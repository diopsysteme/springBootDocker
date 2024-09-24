package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

@Data
public class CompetenceRequest {
    private String nom;
    private int dureeAcquisition;
    private String description;
    private String type;

}
