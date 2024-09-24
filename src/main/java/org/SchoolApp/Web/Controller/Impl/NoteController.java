package org.SchoolApp.Web.Controller.Impl;

import org.SchoolApp.Datas.Entity.NotesEntity;
import org.SchoolApp.Web.Controller.Interfaces.CrudController;
import org.SchoolApp.Web.Dtos.Mapper.NoteRequestMapper;
import org.SchoolApp.Web.Dtos.Request.NoteRequest;
import org.SchoolApp.Web.Dtos.Request.NoteUpdate;
import org.SchoolApp.Services.Impl.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private NoteRequestMapper noteRequestMapper;

    @PostMapping("/apprenants")
    public HashSet<NotesEntity> addNoteModules(@RequestBody List<NoteRequest> noteRequest){
        HashSet<NotesEntity> notes = (HashSet<NotesEntity>) noteRequest.stream().map(noteRequestMapper::toEntity).collect(Collectors.toSet());
        System.out.println(noteRequest);
        return noteService.addNotesModules(notes);
    }

    @PostMapping("modules/{id}")
    public List<NotesEntity> addNotesGroupe(@RequestBody List<NoteRequest> noteRequest){
        List<NotesEntity> notes = (List<NotesEntity>) noteRequest.stream().map(noteRequestMapper::toEntity).collect(Collectors.toSet());
        return noteService.addNotesGroupe(notes);
    }

    @PatchMapping("apprenants/{id}")
    public List<NoteUpdate> updateNoteModules(@RequestBody List<NoteUpdate> noteUpdate) throws Exception {
        return noteService.updateNotes(noteUpdate);
    }

    @GetMapping("")
    public List<NotesEntity> findAll(){
        System.out.println(noteService.findAll());
        return  noteService.findAll();
    }

    @GetMapping("referentiels/{id}")
    public List<NotesEntity> findByReferentiel(@RequestParam Long referentielId){
        return noteService.findByReferentiel(referentielId);
    }
}
