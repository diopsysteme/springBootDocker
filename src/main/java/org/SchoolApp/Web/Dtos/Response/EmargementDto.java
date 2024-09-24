package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.SchoolApp.Datas.Entity.UserEntity;
import org.SchoolApp.Web.Dtos.BaseDto;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
public class EmargementDto {
    private Long id;
    private String date;
    private String entree;
    private String sortie;
}
