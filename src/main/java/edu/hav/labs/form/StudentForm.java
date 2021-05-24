package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StudentForm
  @version  1.0.0 
  @since 15.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentForm {
    private String membership;
    private String university;
    private String faculty;
    private String studentId;

    public StudentForm() {
        this.membership = "";
        this.university = "";
        this.faculty = "";
        this.studentId = "";
    }
}
