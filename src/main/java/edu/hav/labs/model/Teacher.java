package edu.hav.labs.model;

import java.util.Arrays;
import java.util.Objects;

public class Teacher {
    private String id;
    private Membership membership;
    private String[] lessons;
    private String school;

    public Teacher() {
    }

    public Teacher(String id, Membership membership, String[] lessons, String school) {
        this.id = id;
        this.membership = membership;
        this.lessons = lessons;
        this.school = school;
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

    public String[] getLessons() {
        return lessons;
    }

    public void setLessons(String[] lessons) {
        this.lessons = lessons;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(membership, teacher.membership) && Arrays.equals(lessons, teacher.lessons) && Objects.equals(school, teacher.school);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, membership, school);
        result = 31 * result + Arrays.hashCode(lessons);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", membership=" + membership +
                ", lessons=" + Arrays.toString(lessons) +
                ", school='" + school + '\'' +
                '}';
    }
}
