package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  MembershipForm
  @version  1.0.0 
  @since 25.04.2021
*/


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class MembershipForm {
    private String name;
    private String phone;
    private String library;
    private String dateOfRegistration;
    private String isValidUntil;

    public MembershipForm() {
        this.name = "";
        this.phone = "+3809" + (int) (Math.random() * 88888888 + 10000000);
        this.library = String.valueOf((int) (Math.random() * 5 + 1));
        LocalDate startDate = LocalDate.of(2015, 1, 1); //start date
        long start = startDate.toEpochDay();
        LocalDate endDate = LocalDate.now(); //end date
        long end = endDate.toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        this.dateOfRegistration = LocalDate.ofEpochDay(randomEpochDay).toString();
        this.isValidUntil = "";
    }
}
