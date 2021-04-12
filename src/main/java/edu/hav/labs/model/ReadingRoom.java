package edu.hav.labs.model;

import java.util.List;
import java.util.Objects;

public class ReadingRoom {
    private String id;
    private Library library;
    private List<Staff> staff;

    public ReadingRoom() {
    }

    public ReadingRoom(String id, Library library, List<Staff> staff) {
        this.id = id;
        this.library = library;
        this.staff = staff;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public List<Staff> getStaff() {
        return staff;
    }

    public void setStaff(List<Staff> staff) {
        this.staff = staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReadingRoom that = (ReadingRoom) o;
        return Objects.equals(id, that.id) && Objects.equals(library, that.library) && Objects.equals(staff, that.staff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, library, staff);
    }

    @Override
    public String toString() {
        return "ReadingRoom{" +
                "id='" + id + '\'' +
                ", library=" + library +
                ", staff=" + staff +
                '}';
    }
}
