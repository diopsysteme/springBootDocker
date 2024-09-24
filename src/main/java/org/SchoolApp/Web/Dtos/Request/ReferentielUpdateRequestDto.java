package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

import java.util.List;

@Data
public class ReferentielUpdateRequestDto {
    private String libelle;
    private String description;
    private List<CompetenceUpdateRequestDto> competences;
}
