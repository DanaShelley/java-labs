package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  DecommissionedBookForm
  @version  1.0.0 
  @since 06.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DecommissionedBookForm {
    private String  book;
    private String  dateOfDecommission;
    private String  reason;

    public DecommissionedBookForm() {
        this.book = "";
        this.dateOfDecommission = LocalDate.now().toString();
        this.reason = "";
    }
}
