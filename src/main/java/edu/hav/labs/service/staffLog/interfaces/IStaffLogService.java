package edu.hav.labs.service.staffLog.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IStaffLogService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.StaffLog;

import java.util.List;

public interface IStaffLogService {
    StaffLog getById(String id);
    StaffLog create(StaffLog staffLog);
    StaffLog update(StaffLog staffLog);
    StaffLog delete(String id);
    List<StaffLog> getAll();
}
