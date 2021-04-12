package edu.hav.labs.model;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import java.util.List;
import java.util.Objects;

public class StorageRoom {
    private String id;
    private Library library;
    private List<Staff> staff;

    public StorageRoom() {
    }

    public StorageRoom(String id, Library library, List<Staff> staff) {
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
        StorageRoom that = (StorageRoom) o;
        return Objects.equals(id, that.id) && Objects.equals(library, that.library) && Objects.equals(staff, that.staff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, library, staff);
    }

    @Override
    public String toString() {
        return "StorageRoom{" +
                "id='" + id + '\'' +
                ", library=" + library +
                ", staff=" + staff +
                '}';
    }
}
