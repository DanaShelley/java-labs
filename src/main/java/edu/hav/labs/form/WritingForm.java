package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  WritingForm
  @version  1.0.0 
  @since 26.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WritingForm {
    private String name;
    private String authors;
    private String yearOfWriting;
    private String numberOfPages;
    private String genre;
    private String category;

    public WritingForm() {
        this.name = "";
        this.authors = "";
        this.yearOfWriting = "";
        this.numberOfPages = "";
        this.genre = "";
        this.category = "";
    }
}
