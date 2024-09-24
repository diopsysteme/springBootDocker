package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;

@Data
public class NoteUpdate {
    private Long noteId;
    private float note;
}
