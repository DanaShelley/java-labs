package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  EditionForm
  @version  1.0.0 
  @since 27.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EditionForm {
    private String name;
    private String year;
    private String genre;
    private String category;
    private String numberOfPages;
    private String stockNumber;
    private String writings;

    public EditionForm() {
        this.name = "";
        this.year = "";
        this.genre = "";
        this.category = "";
        this.numberOfPages = "";
        this.stockNumber = "";
        this.writings = "";
    }
}
