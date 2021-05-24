package edu.hav.labs.form;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StorageRoomForm
  @version  1.0.0 
  @since 30.04.2021
*/
@Data
@AllArgsConstructor
public class StorageRoomForm {
    private String library;
    private String staffs;
    private String number;

    public StorageRoomForm() {
        this.library = "";
        this.staffs = "";
        this.number = "";
    }
}
