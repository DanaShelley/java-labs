package edu.hav.labs.model;

/*
  @author   Havaleshko Bohdana
  @project   labs
  @version  1.0.0
  @since 13.04.2021
*/

import java.time.LocalDate;
import java.util.Objects;

public class StaffLog {
    private Staff staff;
    private ReadingRoom readingRoom;
    private LocalDate startDate;
    private LocalDate endDate;

    public StaffLog() {
    }

    public StaffLog(Staff staff, ReadingRoom readingRoom, LocalDate startDate, LocalDate endDate) {
        this.staff = staff;
        this.readingRoom = readingRoom;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public ReadingRoom getReadingRoom() {
        return readingRoom;
    }

    public void setReadingRoom(ReadingRoom readingRoom) {
        this.readingRoom = readingRoom;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffLog staffLog = (StaffLog) o;
        return Objects.equals(staff, staffLog.staff) && Objects.equals(readingRoom, staffLog.readingRoom) && Objects.equals(startDate, staffLog.startDate) && Objects.equals(endDate, staffLog.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(staff, readingRoom, startDate, endDate);
    }

    @Override
    public String toString() {
        return "StaffLog{" +
                "staff=" + staff +
                ", readingRoom=" + readingRoom +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
