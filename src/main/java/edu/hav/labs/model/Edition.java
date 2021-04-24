package edu.hav.labs.model;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import java.util.List;
import java.util.Objects;

public class Edition {
    private String id;
    private String name;
    private int year;
    private String genre;
    private String category;
    private int numberOfPages;
    private int stockNumber;
    private List<Writing> writings;

    public Edition() {
    }

    public Edition(String id, String name, int year, String genre, String category, int numberOfPages, int stockNumber, List<Writing> writings) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.category = category;
        this.numberOfPages = numberOfPages;
        this.stockNumber = stockNumber;
        this.writings = writings;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.stockNumber = stockNumber;
    }

    public List<Writing> getWritings() {
        return writings;
    }

    public void setWritings(List<Writing> writings) {
        this.writings = writings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edition edition = (Edition) o;
        return year == edition.year && numberOfPages == edition.numberOfPages && stockNumber == edition.stockNumber && Objects.equals(id, edition.id) && Objects.equals(name, edition.name) && Objects.equals(genre, edition.genre) && Objects.equals(category, edition.category) && Objects.equals(writings, edition.writings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year, genre, category, numberOfPages, stockNumber, writings);
    }

    @Override
    public String toString() {
        return "Edition{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", category='" + category + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", stockNumber=" + stockNumber +
                ", writings=" + writings +
                '}';
    }
}
