package edu.hav.labs.model;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import java.time.LocalDate;
import java.util.Objects;

public class BookLog {
    private String id;
    private Book book;
    private Membership membership;
    private Staff staff;
    private LocalDate date;

    public BookLog() {
    }

    public BookLog(String id, Book book, Membership membership, Staff staff, LocalDate date) {
        this.id = id;
        this.book = book;
        this.membership = membership;
        this.staff = staff;
        this.date = date;
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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookLog bookLog = (BookLog) o;
        return Objects.equals(id, bookLog.id) && Objects.equals(book, bookLog.book) && Objects.equals(membership, bookLog.membership) && Objects.equals(staff, bookLog.staff) && Objects.equals(date, bookLog.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book, membership, staff, date);
    }

    @Override
    public String toString() {
        return "BookLog{" +
                "id='" + id + '\'' +
                ", book=" + book +
                ", membership=" + membership +
                ", staff=" + staff +
                ", date=" + date +
                '}';
    }
}
