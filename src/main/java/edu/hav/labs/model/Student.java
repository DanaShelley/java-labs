package edu.hav.labs.model;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import java.util.Objects;

public class Student {
    private String id;
    private Membership membership;
    private String university;
    private String faculty;
    private String studentId;

    public Student() {
    }

    public Student(String id, Membership membership, String university, String faculty, String studentId) {
        this.id = id;
        this.membership = membership;
        this.university = university;
        this.faculty = faculty;
        this.studentId = studentId;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(membership, student.membership) && Objects.equals(university, student.university) && Objects.equals(faculty, student.faculty) && Objects.equals(studentId, student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, membership, university, faculty, studentId);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", membership=" + membership +
                ", university='" + university + '\'' +
                ", faculty='" + faculty + '\'' +
                ", studentId='" + studentId + '\'' +
                '}';
    }
}
