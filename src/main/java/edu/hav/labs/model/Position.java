package edu.hav.labs.model;

import java.util.Objects;

public class Position {
    private String id;
    private String position;
    private int salary;

    public Position() {
    }

    public Position(String id, String position, int salary) {
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return salary == position1.salary && Objects.equals(id, position1.id) && Objects.equals(position, position1.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position, salary);
    }

    @Override
    public String toString() {
        return "Position{" +
                "id='" + id + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
