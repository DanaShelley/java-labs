package edu.hav.labs.model;

import java.util.Objects;

public class Scientist {
    private String id;
    private Membership membership;
    private String nameOfOrganization;
    private String specialization;

    public Scientist() {
    }

    public Scientist(String id, Membership membership, String nameOfOrganization, String specialization) {
        this.id = id;
        this.membership = membership;
        this.nameOfOrganization = nameOfOrganization;
        this.specialization = specialization;
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

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scientist scientist = (Scientist) o;
        return Objects.equals(id, scientist.id) && Objects.equals(membership, scientist.membership) && Objects.equals(nameOfOrganization, scientist.nameOfOrganization) && Objects.equals(specialization, scientist.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, membership, nameOfOrganization, specialization);
    }

    @Override
    public String toString() {
        return "Scientist{" +
                "id='" + id + '\'' +
                ", membership=" + membership +
                ", nameOfOrganization='" + nameOfOrganization + '\'' +
                ", specialization='" + specialization + '\'' +
                '}';
    }
}
