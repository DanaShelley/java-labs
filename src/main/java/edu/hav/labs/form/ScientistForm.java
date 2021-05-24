package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  ScientistForm
  @version  1.0.0 
  @since 14.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ScientistForm {
    private String membership;
    private String nameOfOrganization;
    private String specialization;

    public ScientistForm() {
        this.membership = "";
        this.nameOfOrganization = "";
        this.specialization = "";
    }
}
