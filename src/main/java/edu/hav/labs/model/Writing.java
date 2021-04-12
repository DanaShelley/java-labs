package edu.hav.labs.model;

import java.util.List;
import java.util.Objects;

public class Writing {
    private String id;
    private String name;
    private List<String> authors;
    private String yearOfWriting;
    private int numberOfPages;
    private String genre;
    private String category;

    public Writing() {
    }

    public Writing(String id, String name, List<String> authors, String yearOfWriting, int numberOfPages, String genre, String category) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.yearOfWriting = yearOfWriting;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getYearOfWriting() {
        return yearOfWriting;
    }

    public void setYearOfWriting(String yearOfWriting) {
        this.yearOfWriting = yearOfWriting;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writing writing = (Writing) o;
        return numberOfPages == writing.numberOfPages && Objects.equals(id, writing.id) && Objects.equals(name, writing.name) && Objects.equals(authors, writing.authors) && Objects.equals(yearOfWriting, writing.yearOfWriting) && Objects.equals(genre, writing.genre) && Objects.equals(category, writing.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, authors, yearOfWriting, numberOfPages, genre, category);
    }

    @Override
    public String toString() {
        return "Writing{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                ", yearOfWriting='" + yearOfWriting + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", genre='" + genre + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
