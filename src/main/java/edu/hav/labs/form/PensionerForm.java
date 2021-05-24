package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  PensionerForm
  @version  1.0.0 
  @since 14.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PensionerForm {
    private String membership;
    private String age;
    private String pensionerId;

    public PensionerForm() {
        this.membership = "";
        this.age = "";
        this.pensionerId = "";
    }
}
