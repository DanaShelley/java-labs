package edu.hav.labs.model;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import java.util.Objects;

public class Pensioner {
    private String id;
    private Membership membership;
    private int age;
    private String pensionerId;

    public Pensioner() {
    }

    public Pensioner(String id, Membership membership, int age, String pensionerId) {
        this.id = id;
        this.membership = membership;
        this.age = age;
        this.pensionerId = pensionerId;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPensionerId() {
        return pensionerId;
    }

    public void setPensionerId(String pensionerId) {
        this.pensionerId = pensionerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pensioner pensioner = (Pensioner) o;
        return age == pensioner.age && Objects.equals(id, pensioner.id) && Objects.equals(membership, pensioner.membership) && Objects.equals(pensionerId, pensioner.pensionerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, membership, age, pensionerId);
    }

    @Override
    public String toString() {
        return "Pensioner{" +
                "id='" + id + '\'' +
                ", membership=" + membership +
                ", age=" + age +
                ", pensionerId='" + pensionerId + '\'' +
                '}';
    }
}
