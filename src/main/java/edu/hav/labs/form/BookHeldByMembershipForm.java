package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookHeldByMembershipForm
  @version  1.0.0 
  @since 12.05.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class BookHeldByMembershipForm {
    private String  book;
    private String  membership;
    private String  dateOfLending;
    private String  deliveryDate;

    public BookHeldByMembershipForm() {
        this.book = "";
        this.membership = "";

        LocalDate startDate = LocalDate.of(2021, 5, 9); //start date
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.now(); //end date
        long end = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

        this.dateOfLending = String.valueOf(LocalDate.ofEpochDay(randomEpochDay));
        this.deliveryDate = LocalDate.now().toString();
    }
}
