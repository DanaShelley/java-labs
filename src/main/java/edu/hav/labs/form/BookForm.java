package edu.hav.labs.form;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @class  BookForm
  @version  1.0.0 
  @since 30.04.2021
*/

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

@Data
@AllArgsConstructor
public class BookForm {
    private String edition;
    private String membership;
    private String rule;
    private String storageRoom;
    private String stellageNumber;
    private String shelveNumber;
    private String inventoryNumber;
    private String dateOfReceipt;
    private String isDecommissioned;

    public BookForm() {
        this.edition = "";
        this.membership = "";
        this.rule = "";
        this.storageRoom = "";
        this.stellageNumber = String.valueOf((int) (Math.random()*5+1));
        this.shelveNumber = String.valueOf((int) (Math.random()*8+1));
        this.inventoryNumber = String.valueOf((int) (Math.random()*90000000+10000000));

        LocalDate startDate = LocalDate.of(2018, 1, 1); //start date
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.now(); //end date
        long end = endDate.toEpochDay();

        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();

        this.dateOfReceipt = String.valueOf(LocalDate.ofEpochDay(randomEpochDay));
        this.isDecommissioned = "";
    }
}
