package edu.hav.labs.model;

import java.util.Objects;

public class ActiveBook {
    private String id;
    private Book book;

    public ActiveBook() {
    }

    public ActiveBook(String id, Book book) {
        this.id = id;
        this.book = book;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActiveBook that = (ActiveBook) o;
        return Objects.equals(id, that.id) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, book);
    }

    @Override
    public String toString() {
        return "ActiveBook{" +
                "id='" + id + '\'' +
                ", book=" + book +
                '}';
    }
}
