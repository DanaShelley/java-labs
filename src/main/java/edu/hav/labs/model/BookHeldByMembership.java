package edu.hav.labs.model;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import java.time.LocalDate;
import java.util.Objects;

public class BookHeldByMembership {
    private String id;
    private Book book;
    private Membership membership;
    private LocalDate dateOfLending;
    private LocalDate deliveryDate;

    public BookHeldByMembership() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public LocalDate getDateOfLending() {
        return dateOfLending;
    }

    public void setDateOfLending(LocalDate dateOfLending) {
        this.dateOfLending = dateOfLending;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookHeldByMembership that = (BookHeldByMembership) o;
        return Objects.equals(id, that.id) && Objects.equals(book, that.book) && Objects.equals(membership, that.membership) && Objects.equals(dateOfLending, that.dateOfLending) && Objects.equals(deliveryDate, that.deliveryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, membership, dateOfLending, deliveryDate);
    }

    @Override
    public String toString() {
        return "BookHeldByMembership{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", membership=" + membership +
                ", dateOfLending=" + dateOfLending +
                ", deliveryDate=" + deliveryDate +
                '}';
    }
}
