package edu.hav.labs.model;

import java.time.LocalDate;
import java.util.Objects;

public class Staff {
    private String id;
    private String name;
    private String phone;
    private Position position;
    private Library library;
    private LocalDate employmentDate;

    public Staff() {
    }

    public Staff(String id, String name, String phone, Position position, Library library, LocalDate employmentDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.position = position;
        this.library = library;
        this.employmentDate = employmentDate;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(id, staff.id) && Objects.equals(name, staff.name) && Objects.equals(phone, staff.phone) && Objects.equals(position, staff.position) && Objects.equals(library, staff.library) && Objects.equals(employmentDate, staff.employmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, position, library, employmentDate);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", position=" + position +
                ", library=" + library +
                ", employmentDate=" + employmentDate +
                '}';
    }
}
