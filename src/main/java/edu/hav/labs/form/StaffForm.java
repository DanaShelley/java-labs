package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffForm
  @version  1.0.0 
  @since 27.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StaffForm {
    private String name;
    private String phone;
    private String position;
    private String library;
    private String employmentDate;

    public StaffForm() {
        this.name = "";
        this.phone = "";
        this.position = "";
        this.library = "";
        this.employmentDate = LocalDate.now().toString();
    }
}
