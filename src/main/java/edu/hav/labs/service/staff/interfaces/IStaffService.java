package edu.hav.labs.service.staff.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IStaffService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Staff;

import java.util.List;

public interface IStaffService {
    Staff getById(String id);
    Staff create(Staff staff);
    Staff update(Staff staff);
    Staff delete(String id);
    List<Staff> getAll();
}
