package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.SchoolApp.Datas.Entity.PromoEntity;
import org.SchoolApp.Datas.Entity.ReferentielEntity;
import org.SchoolApp.Datas.Enums.EtatEnum;
import org.SchoolApp.Web.Validators.UniqueField;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

@Data
public class PromoRequest {
    @NotBlank
    @UniqueField(entity = PromoEntity.class,field = "libelle")
    private String libelle;

    @NotBlank
    private Date dateDebut;
    @NotBlank
    @Future
    private Date dateFin;
    @NotBlank
    private boolean deleted;
    @NotBlank
    private int duree;
    @NotBlank
    private EtatEnum etat;
    private Optional<Set<ReferentielEntity>> referentiels;
}
