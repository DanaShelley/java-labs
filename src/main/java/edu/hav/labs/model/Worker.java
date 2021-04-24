package edu.hav.labs.model;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import java.util.Objects;

public class Worker {
    private String id;
    private Membership membership;
    private Library library;

    public Worker() {
    }

    public Worker(String id, Membership membership, Library library) {
        this.id = id;
        this.membership = membership;
        this.library = library;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(id, worker.id) && Objects.equals(membership, worker.membership) && Objects.equals(library, worker.library);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, membership, library);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", membership=" + membership +
                ", library=" + library +
                '}';
    }
}
