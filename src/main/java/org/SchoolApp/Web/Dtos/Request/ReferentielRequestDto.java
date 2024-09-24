package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

import java.util.List;

@Data
public class ReferentielRequestDto {
    private String libelle;
    private String code;
    private String description;
    private String photo_couverture;
    private List<CompetenceRequestDto> competences;
}
