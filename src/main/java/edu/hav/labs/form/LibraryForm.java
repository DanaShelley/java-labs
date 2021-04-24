package edu.hav.labs.form;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

public class LibraryForm {
    private String name;
    private String address;
    private int numberOfBooks;
    private int numberOfMembership;

    public LibraryForm() {
        name = "";
        address = "";
        numberOfBooks = 0;
        numberOfMembership = 0;
    }

    public LibraryForm(String name, String address, int numberOfBooks, int numberOfMembership) {
        this.name = name;
        this.address = address;
        this.numberOfBooks = numberOfBooks;
        this.numberOfMembership = numberOfMembership;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public int getNumberOfMembership() {
        return numberOfMembership;
    }

    public void setNumberOfMembership(int numberOfMembership) {
        this.numberOfMembership = numberOfMembership;
    }
}
