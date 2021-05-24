package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  TeacherForm
  @version  1.0.0 
  @since 15.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TeacherForm {
    private String membership;
    private String lessons;
    private String school;

    public TeacherForm() {
        this.membership = "";
        this.lessons = "";
        this.school = "";
    }
}
