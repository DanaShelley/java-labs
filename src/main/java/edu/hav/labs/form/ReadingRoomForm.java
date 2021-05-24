package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  ReadingRoomForm
  @version  1.0.0 
  @since 29.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReadingRoomForm {
    private String library;
    private String staffs;
    private String number;

    public ReadingRoomForm() {
        this.library = "";
        this.staffs = "";
        this.number = "";
    }
}
