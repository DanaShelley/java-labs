package edu.hav.labs.model;

import java.util.Objects;

public class Schoolchild {
    private String id;
    private Membership membership;
    private String school;
    private int grade;
    private int age;

    public Schoolchild() {
    }

    public Schoolchild(String id, Membership membership, String school, int grade, int age) {
        this.id = id;
        this.membership = membership;
        this.school = school;
        this.grade = grade;
        this.age = age;
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

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schoolchild that = (Schoolchild) o;
        return grade == that.grade && age == that.age && Objects.equals(id, that.id) && Objects.equals(membership, that.membership) && Objects.equals(school, that.school);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, membership, school, grade, age);
    }

    @Override
    public String toString() {
        return "Schoolchild{" +
                "id='" + id + '\'' +
                ", membership=" + membership +
                ", school='" + school + '\'' +
                ", grade=" + grade +
                ", age=" + age +
                '}';
    }
}
