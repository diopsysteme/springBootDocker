package org.SchoolApp.Web.Dtos.Request;

import lombok.Data;
import org.SchoolApp.Datas.Entity.PromoEntity;
import org.SchoolApp.Datas.Enums.EtatEnum;
import org.SchoolApp.Web.Validators.UniqueField;

import java.util.Date;

@Data
public class PromoUpdateRequest {
    @UniqueField(entity = PromoEntity.class,field = "libelle")
    private String libelle;
    private Date dateDebut;
    private Date dateFin;
    private boolean deleted;
    private int duree;
    private EtatEnum etat;
}
