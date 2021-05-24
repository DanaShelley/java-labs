package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookLog
  @version  1.0.0 
  @since 14.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class BookLogForm {
    private String book;
    private String membership;
    private String staff;
    private String date;

    public BookLogForm() {
        this.book = "";
        this.membership = "";
        this.staff = "";

        LocalDate startDate = LocalDate.of(2018, 1, 1); //start date
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.now(); //end date
        long end = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

        this.date = String.valueOf(LocalDate.ofEpochDay(randomEpochDay));
    }
}
