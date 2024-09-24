package org.SchoolApp.Web.Controller.Impl;

import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.StatusReferenceEnum;
import org.SchoolApp.Services.Interfaces.ReferentielService;
import org.SchoolApp.Web.Dtos.Mapper.ReferentielMapper;
import org.SchoolApp.Web.Dtos.Request.ReferentielRequestDto;
import org.SchoolApp.Web.Dtos.Request.ReferentielUpdateRequestDto;
import org.SchoolApp.Web.Dtos.Response.ReferentielResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/referentiels")
public class ReferentielController {

    @Autowired
    private ReferentielService referentielService;

    @Autowired
    private ReferentielMapper referentielMapper;

    @PostMapping
    public ResponseEntity<ReferentielResponseDto> createReferentiel(@RequestBody ReferentielRequestDto referentielRequestDto) {
        var referentielEntity = referentielMapper.toEntity(referentielRequestDto);
        var savedReferentiel = referentielService.createReferentiel(referentielEntity);
        return ResponseEntity.ok(referentielMapper.toDto(savedReferentiel));
    }


    @GetMapping
    public ResponseEntity<List<ReferentielResponseDto>> listReferentiels(@RequestParam(required = false) StatusReferenceEnum status) {
        List<ReferentielEntity> referentiels;

        if (status != null) {
            referentiels = referentielService.listReferentielsByStatus(status);
        } else {
            referentiels = referentielService.listActiveReferentiels();  // Liste des référentiels actifs
        }
        List<ReferentielResponseDto> responseDtos = referentiels.stream()
                .map(referentielMapper::toDto)
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDtos);
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReferentiel(@PathVariable Long id) {
        referentielService.deleteReferentiel(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/archive")
    public ResponseEntity<List<ReferentielEntity>> listArchivedReferentiels() {
        return ResponseEntity.ok(referentielService.listArchivedReferentiels());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReferentielResponseDto> getReferentielById(@PathVariable Long id) {
        ReferentielEntity referentiel = referentielService.getReferentielById(id);
        if (referentiel == null) {
            return ResponseEntity.notFound().build();
        }
        ReferentielResponseDto referentielDto = referentielMapper.toDto(referentiel);
        return ResponseEntity.ok(referentielDto);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ReferentielResponseDto> modifyReferentiel(
            @PathVariable Long id,
            @RequestBody ReferentielUpdateRequestDto referentielUpdateRequestDto) {
        try {
            ReferentielEntity updates = referentielMapper.toEntity(referentielUpdateRequestDto);
            ReferentielEntity updatedReferentiel = referentielService.updateReferentielWithDetails(id, updates);
            return ResponseEntity.ok(referentielMapper.toDto(updatedReferentiel));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
