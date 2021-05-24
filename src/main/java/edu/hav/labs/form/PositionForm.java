package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  PositionForm
  @version  1.0.0 
  @since 26.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PositionForm {
    private String position;
    private String salary;

    public PositionForm() {
        this.position = "";
        this.salary = "";
    }
}
