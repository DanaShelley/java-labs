package edu.hav.labs.model;

import java.time.LocalDate;
import java.util.Objects;

public class Membership {
    private String id;
    private String name;
    private Library library;
    private LocalDate dateOfRegistration;
    private LocalDate isValidUntil;

    public Membership() {
    }

    public Membership(String id, String name, Library library, LocalDate dateOfRegistration, LocalDate isValidUntil) {
        this.id = id;
        this.name = name;
        this.library = library;
        this.dateOfRegistration = dateOfRegistration;
        this.isValidUntil = isValidUntil;
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

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public LocalDate getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(LocalDate dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public LocalDate getIsValidUntil() {
        return isValidUntil;
    }

    public void setIsValidUntil(LocalDate isValidUntil) {
        this.isValidUntil = isValidUntil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membership that = (Membership) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(library, that.library) && Objects.equals(dateOfRegistration, that.dateOfRegistration) && Objects.equals(isValidUntil, that.isValidUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, library, dateOfRegistration, isValidUntil);
    }

    @Override
    public String toString() {
        return "Membership{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", library=" + library +
                ", dateOfRegistration=" + dateOfRegistration +
                ", isValidUntil=" + isValidUntil +
                '}';
    }
}
