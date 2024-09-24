package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

@Data
public class NoteRequest {
    private float note;
    private Long apprenant;
    private Long module;
}
