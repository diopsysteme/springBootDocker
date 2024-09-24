package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;

import java.util.List;

@Data
public class ReferentielResponseDto {
    private Long id;
    private String libelle;
    private String code;
    private String description;
    private String photoCouverture;
    private List<CompetenceResponseDto> competences;
}
