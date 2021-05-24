package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  SchoolshildForm
  @version  1.0.0 
  @since 14.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SchoolchildForm {
    private String membership;
    private String school;
    private String grade;
    private String age;

    public SchoolchildForm() {
        this.membership = "";
        this.school = "";
        this.grade = "";
        this.age = "";
    }
}
