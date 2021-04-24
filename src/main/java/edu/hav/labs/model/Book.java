package edu.hav.labs.model;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String id;
    private Edition edition;
    private Membership membership;
    private Rule rule;
    private StorageRoom storageRoom;
    private int stellageNumber;
    private int shelveNumber;
    private LocalDate dateOdReceipt;

    public Book() {
    }

    public Book(String id, Edition edition, Membership membership, Rule rule, StorageRoom storageRoom, int stellageNumber, int shelveNumber, LocalDate dateOdReceipt) {
        this.id = id;
        this.edition = edition;
        this.membership = membership;
        this.rule = rule;
        this.storageRoom = storageRoom;
        this.stellageNumber = stellageNumber;
        this.shelveNumber = shelveNumber;
        this.dateOdReceipt = dateOdReceipt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Edition getEdition() {
        return edition;
    }

    public void setEdition(Edition edition) {
        this.edition = edition;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public StorageRoom getStorageRoom() {
        return storageRoom;
    }

    public void setStorageRoom(StorageRoom storageRoom) {
        this.storageRoom = storageRoom;
    }

    public int getStellageNumber() {
        return stellageNumber;
    }

    public void setStellageNumber(int stellageNumber) {
        this.stellageNumber = stellageNumber;
    }

    public int getShelveNumber() {
        return shelveNumber;
    }

    public void setShelveNumber(int shelveNumber) {
        this.shelveNumber = shelveNumber;
    }

    public LocalDate getDateOdReceipt() {
        return dateOdReceipt;
    }

    public void setDateOdReceipt(LocalDate dateOdReceipt) {
        this.dateOdReceipt = dateOdReceipt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return stellageNumber == book.stellageNumber && shelveNumber == book.shelveNumber && Objects.equals(id, book.id) && Objects.equals(edition, book.edition) && Objects.equals(membership, book.membership) && rule == book.rule && Objects.equals(storageRoom, book.storageRoom) && Objects.equals(dateOdReceipt, book.dateOdReceipt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, edition, membership, rule, storageRoom, stellageNumber, shelveNumber, dateOdReceipt);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", edition=" + edition +
                ", membership=" + membership +
                ", rule=" + rule +
                ", storageRoom=" + storageRoom +
                ", stellageNumber=" + stellageNumber +
                ", shelveNumber=" + shelveNumber +
                ", dateOdReceipt=" + dateOdReceipt +
                '}';
    }
}
