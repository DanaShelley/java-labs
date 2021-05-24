package edu.hav.labs.service.student.interfaces;
/*
  @author   Bohdana Havaleshko
  @project   labs
  @interface  IStudentService
  @version  1.0.0 
  @since 20.04.2021
*/

import edu.hav.labs.model.Student;

import java.util.List;

public interface IStudentService {
    Student getById(String id);
    Student create(Student student);
    Student update(Student student);
    Student delete(String id);
    List<Student> getAll();
}
