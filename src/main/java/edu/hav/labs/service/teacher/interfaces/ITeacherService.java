package edu.hav.labs.service.teacher.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  ITeacherService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Teacher;

import java.util.List;

public interface ITeacherService {
    Teacher getById(String id);
    Teacher create(Teacher teacher);
    Teacher update(Teacher teacher);
    Teacher delete(String id);
    List<Teacher> getAll();
}
