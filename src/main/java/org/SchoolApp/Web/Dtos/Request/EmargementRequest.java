package org.SchoolApp.Web.Dtos.Request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.SchoolApp.Validators.ValidApprenantIds;

import java.util.List;
@Data
public class EmargementRequest {

    @NotEmpty(message = "The apprenantIds list cannot be empty")
    @ValidApprenantIds  // Custom validator to check if each ID is valid
    private List<Long> apprenantIds;

    // Getter and Setter


}
