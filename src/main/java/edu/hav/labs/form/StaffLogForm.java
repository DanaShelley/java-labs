package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  StaffLogForm
  @version  1.0.0 
  @since 14.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class StaffLogForm {
    private String staff;
    private String readingRoom;
    private String startDate;
    private String endDate;

    public StaffLogForm() {
        this.staff = "";
        this.readingRoom = "";
        this.startDate = LocalDate.now().toString();
        this.endDate = "";
    }
}
