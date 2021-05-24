package edu.hav.labs.form;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LibraryForm {
    private String name;
    private String address;
    private String numberOfBooks;
    private String numberOfMembership;

    public LibraryForm() {
        name = "";
        address = "";
        numberOfBooks = "0";
        numberOfMembership = "0";
    }
}
