package edu.hav.labs.model;

import java.time.LocalDate;
import java.util.Objects;

public class DecommissionedBook {
    private String id;
    private Book book;
    private LocalDate dateOfDecimession;
    private String reason;

    public DecommissionedBook() {
    }

    public DecommissionedBook(String id, Book book, LocalDate dateOfDecimession, String reason) {
        this.id = id;
        this.book = book;
        this.dateOfDecimession = dateOfDecimession;
        this.reason = reason;
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

    public LocalDate getDateOfDecimession() {
        return dateOfDecimession;
    }

    public void setDateOfDecimession(LocalDate dateOfDecimession) {
        this.dateOfDecimession = dateOfDecimession;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DecommissionedBook that = (DecommissionedBook) o;
        return Objects.equals(id, that.id) && Objects.equals(book, that.book) && Objects.equals(dateOfDecimession, that.dateOfDecimession) && Objects.equals(reason, that.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, dateOfDecimession, reason);
    }

    @Override
    public String toString() {
        return "DecommissionedBook{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", dateOfDecimession=" + dateOfDecimession +
                ", reason='" + reason + '\'' +
                '}';
    }
}
